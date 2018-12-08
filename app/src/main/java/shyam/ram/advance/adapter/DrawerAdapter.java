package shyam.ram.advance.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shyam.ram.advance.R;
import shyam.ram.advance.databinding.DrawerLayoutBinding;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.Holder>{
    private String[] menu;
    private TypedArray icons;
    private LayoutInflater layoutInflater;
    private RecyclerViewClickListener mListener;
    private Context context;
    public DrawerAdapter(Context mainActivity,RecyclerViewClickListener mListener) {
        this.context=mainActivity;
        this.mListener=mListener;
        icons = mainActivity.getResources().obtainTypedArray(R.array.drawer_menu_icon);
        menu = mainActivity.getResources().getStringArray(R.array.drawer_list_with_order);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        DrawerLayoutBinding drawerLayoutBinding = DataBindingUtil.inflate(layoutInflater
                , R.layout.drawer_layout, viewGroup, false);
        return new Holder(drawerLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.bind(icons.getDrawable(i), menu[i],mListener,i);
    }

    @Override
    public int getItemCount() {
        return menu.length;
    }


    class Holder extends RecyclerView.ViewHolder {
        private DrawerLayoutBinding drawerLayoutBinding;

        Holder(@NonNull DrawerLayoutBinding itemView) {
            super(itemView.getRoot());
            this.drawerLayoutBinding = itemView;
        }

        void bind(Drawable drawable, final String menu, final RecyclerViewClickListener mListener, final int i) {
            drawerLayoutBinding.drawericon.setImageDrawable(drawable);
            drawerLayoutBinding.drawerList.setText(menu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(menu,i);
                }
            });
        }
    }
    public interface RecyclerViewClickListener {

        void onClick(String drawable,int i);
    }
}
