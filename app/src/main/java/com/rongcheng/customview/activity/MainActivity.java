package com.rongcheng.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rongcheng.customview.R;

public class MainActivity extends AppCompatActivity {

    public static final String[] options = {
            "Demo Show",
            "Pie Demo",
            "Path Demo",
            "蜘蛛雷达",
            "贝赛尔曲线",
            "搜索",
            "事件传递"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter());

    }


    private static class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final ItemViewHolder holder = ItemViewHolder.newInstance(parent);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Class clazz = null;
                    switch (holder.getAdapterPosition()) {
                        case 0:
                            clazz = DemoActivity.class;
                            break;
                        case 1:
                            clazz = PieActivity.class;

                            break;
                        case 2:
                            clazz = PathActivity.class;
                            break;
                        case 3:
                            clazz = RadarActivity.class;
                            break;
                        case 4:
                            clazz = BeiSaiActivity.class;
                            break;
                        case 5:
                            clazz = SearchActivity.class;
                            break;
                        case 6:
                            clazz = TouchDispatchActivity.class;
                            break;

                    }
                    Context context = holder.itemView.getContext();
                    context.startActivity(new Intent(context, clazz));
                }

            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            holder.bind(options[position]);
        }

        @Override
        public int getItemCount() {
            return options.length;
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextTitle;

        static ItemViewHolder newInstance(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample, parent, false);
            return new ItemViewHolder(view);
        }

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.title);
        }

        private void bind(String title) {
            mTextTitle.setText(title);
        }
    }
}
