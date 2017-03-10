package com.phoenix.headlineview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeadLineView headLineView = (HeadLineView) findViewById(R.id.headline);
        MyAdapter myAdapter = new MyAdapter(this, R.layout.item_show);
        headLineView.setAdapter(myAdapter);

        List<MyModel> data = new ArrayList<>();
        data.add(new MyModel("aa", "12"));
        data.add(new MyModel("bb", "13"));
        data.add(new MyModel("cc", "14"));

        myAdapter.setData(data);
        myAdapter.start();
    }

    private class MyModel {
        private String name;
        private String age;

        public MyModel(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    private class MyAdapter extends PhoFlipperAdapter<MyModel> {

        public MyAdapter(Context context, int itemLayoutId) {
            super(context, itemLayoutId);
        }

        @Override
        protected void fillData(FlipperHelper helper, int position, MyModel model) {
            TextView name = (TextView) helper.getView(R.id.name);
            name.setText(model.getName());
            TextView age = (TextView) helper.getView(R.id.age);
            age.setText(model.getAge());
        }
    }
}
