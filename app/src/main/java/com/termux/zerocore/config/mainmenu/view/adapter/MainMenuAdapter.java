package com.termux.zerocore.config.mainmenu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.termux.R;
import com.termux.zerocore.config.mainmenu.data.MainMenuCategoryData;
import com.termux.zerocore.config.mainmenu.view.viewholder.MainMenuViewHolder;
import com.termux.zerocore.ftp.utils.UserSetManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 左侧主菜单性能：LayoutManager / 子 Adapter 复用，避免 onBind 反复 new。
 */
public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {
    private Context mContext;
    private ArrayList<MainMenuCategoryData> mMainMenuCategoryData;
    private final HashMap<Integer, MainMenuItemAdapter> mainMenuItemAdapters = new HashMap<>();

    public MainMenuAdapter(Context context, ArrayList<MainMenuCategoryData> mainMenuCategoryData) {
        mContext = context;
        mMainMenuCategoryData = mainMenuCategoryData;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        if (mMainMenuCategoryData == null || position < 0 || position >= mMainMenuCategoryData.size()) {
            return RecyclerView.NO_ID;
        }
        return mMainMenuCategoryData.get(position).mId;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainMenuViewHolder holder = new MainMenuViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.layout_menu_list, parent, false));
        GridLayoutManager glm = new GridLayoutManager(mContext, 3);
        glm.setInitialPrefetchItemCount(6);
        holder.mItemMenuRec.setLayoutManager(glm);
        holder.mItemMenuRec.setHasFixedSize(true);
        holder.mItemMenuRec.setNestedScrollingEnabled(false);
        holder.mItemMenuRec.setItemAnimator(null);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {
        MainMenuCategoryData category = mMainMenuCategoryData.get(position);
        final int id = category.mId;
        holder.mTitle.setText(category.mTitle);

        MainMenuItemAdapter itemAdapter = mainMenuItemAdapters.get(position);
        if (itemAdapter == null) {
            itemAdapter = new MainMenuItemAdapter(mContext, category.mClickArrayList);
            mainMenuItemAdapters.put(position, itemAdapter);
        } else {
            itemAdapter.swapData(category.mClickArrayList);
        }
        if (holder.mItemMenuRec.getAdapter() != itemAdapter) {
            holder.mItemMenuRec.setAdapter(itemAdapter);
        }

        boolean foldEnabled = !UserSetManage.Companion.get().getZTUserBean().isCloseFoldMenu();
        if (foldEnabled) {
            holder.mOpenSettings.setVisibility(View.VISIBLE);
            boolean mainMenuItemShow = UserSetManage.Companion.get().getMainMenuItemShow(String.valueOf(id));
            if (mainMenuItemShow) {
                holder.mOpenSettings.setRotation(180f);
                holder.mItemMenuRec.setVisibility(View.VISIBLE);
            } else {
                holder.mOpenSettings.setRotation(0f);
                holder.mItemMenuRec.setVisibility(View.GONE);
            }
            holder.itemView.setOnClickListener(v -> {
                int adapterPos = holder.getAdapterPosition();
                if (adapterPos == RecyclerView.NO_POSITION || mMainMenuCategoryData == null) {
                    return;
                }
                int visibility = holder.mItemMenuRec.getVisibility();
                if (visibility == View.VISIBLE) {
                    holder.mOpenSettings.setRotation(0f);
                    holder.mItemMenuRec.setVisibility(View.GONE);
                    UserSetManage.Companion.get().setMainMenuItemShow(
                        String.valueOf(mMainMenuCategoryData.get(adapterPos).mId),
                        UserSetManage.Companion.getITEM_GEON());
                } else {
                    holder.mOpenSettings.setRotation(180f);
                    holder.mItemMenuRec.setVisibility(View.VISIBLE);
                    UserSetManage.Companion.get().setMainMenuItemShow(
                        String.valueOf(mMainMenuCategoryData.get(adapterPos).mId),
                        UserSetManage.Companion.getITEM_VISIBLE());
                }
            });
        } else {
            holder.mOpenSettings.setVisibility(View.GONE);
            holder.mItemMenuRec.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(null);
        }
    }

    @Override
    public int getItemCount() {
        return mMainMenuCategoryData == null ? 0 : mMainMenuCategoryData.size();
    }

    public int findGroupIndexByName(String groupName) {
        if (groupName == null || groupName.trim().isEmpty() || mMainMenuCategoryData == null) {
            return -1;
        }
        for (int i = 0; i < mMainMenuCategoryData.size(); i++) {
            if (groupName.equals(mMainMenuCategoryData.get(i).mTitle)) {
                return i;
            }
        }
        return -1;
    }

    public void activateGroup(int index) {
        if (mMainMenuCategoryData == null || index < 0 || index >= mMainMenuCategoryData.size()) {
            return;
        }
        for (int i = 0; i < mMainMenuCategoryData.size(); i++) {
            String id = String.valueOf(mMainMenuCategoryData.get(i).mId);
            String state = (i == index)
                ? UserSetManage.Companion.getITEM_VISIBLE()
                : UserSetManage.Companion.getITEM_GEON();
            UserSetManage.Companion.get().setMainMenuItemShow(id, state);
        }
        notifyDataSetChanged();
    }

    public void release() {
        mContext = null;
        for (Map.Entry<Integer, MainMenuItemAdapter> entry : mainMenuItemAdapters.entrySet()) {
            entry.getValue().release();
        }
        mainMenuItemAdapters.clear();
        if (mMainMenuCategoryData != null) {
            for (int i = 0; i < mMainMenuCategoryData.size(); i++) {
                MainMenuCategoryData data = mMainMenuCategoryData.get(i);
                if (data.mClickArrayList == null) continue;
                for (int j = 0; j < data.mClickArrayList.size(); j++) {
                    data.mClickArrayList.get(j).release();
                }
            }
        }
        mMainMenuCategoryData = null;
    }
}
