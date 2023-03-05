package com.sample.dbtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items; //배열로 한 장소의 이름/주소/아이디/이미지를 묶어서 관리

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.recycler_item,parent,false);

        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //뷰를 홀드(고정하는 역할) 위치를 잡아주고 해당되는 xml에 대입함
        VH vh= (VH) holder;

        Item item= items.get(position); //위치는 item배열로 잡음
        vh.tvName.setText(item.getC_title()); //장소 이름 대입
        vh.tvInfo.setText(item.getC_info());
        vh.tvHref.setText(item.getC_href());
        vh.tvNotice.setText(item.getC_notice());
        vh.tvDate.setText(item.getC_date());

        String i = item.getC_date();
        String e = String.valueOf(item.getC_info());

        if (i.equals("null")){
            vh.tvDate.setText("예정없음");
        } else{

        }
        if (e.equals("0")){
            vh.tvDate.setText("연재중");
        } else{

        }



        //String C = item.getC_notice().replaceAll("[^0-9]", "");
        //String M = C.substring(0,2);
        //String D = C.substring(2,4);

        //Toast.makeText(context.getApplicationContext(), C+M+D, Toast.LENGTH_SHORT).show();

        //vh.tvDate.setText(M);

        Glide.with(context).load(item.getC_img()).into(vh.iv);
        //gilde는 확장 라이브러리 따로 깐 것! 알아서 URL을 이미지로 바꿔줌

        //세부페이지를 위해 추가한부분
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvName = vh.tvName.getText().toString();
                String tvHref = vh.tvHref.getText().toString();
                String tvNotice = vh.tvNotice.getText().toString();
                String tvDate = vh.tvDate.getText().toString();

                //String tvMsg = vh.tvMsg.getText().toString();
                //받은 이미지뷰.
                ImageView imageView = vh.iv;

                Toast.makeText(context.getApplicationContext(), tvNotice, Toast.LENGTH_SHORT).show();
            }
        });
        //역기까지

        vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String tvName = vh.tvName.getText().toString();
                String tvHref = vh.tvHref.getText().toString();
                String tvNotice = vh.tvNotice.getText().toString();
                String tvDate = vh.tvDate.getText().toString();
                //String tvMsg = vh.tvMsg.getText().toString();
                //받은 이미지뷰.
                ImageView imageView = vh.iv;

                Toast.makeText(context.getApplicationContext(), "해당 작품 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(tvHref));
                //Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jihyean"));
                context.startActivity(intentUrl);

                //intentUrl.putExtra("C_href", C_href);


//                Intent intent;
//                intent = new Intent(context, ShopInfo_Activity.class);
//                intent.putExtra("tvName", tvName);
//                intent.putExtra("tvMsg", tvMsg);
//
//                //우선. 받은 이미지를 비트맵 형식을 바꾼다
//                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
//                Bitmap bitmap = drawable.getBitmap();
//                //비트맵 형식으로 바꾼 이미지 뷰를 비트 어레이로 변경하여 putextra로 보낸다
//                //이후 받은곳에서 다시 bitmap으로 변환하여 이미지뷰에 사용한ㄷ.
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
//                intent.putExtra("tvImage",byteArray);
//
//                context.startActivity(intent);
                return true;
            }
        });

    }
//그냥 뷰 정의
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvInfo;
        TextView tvHref;
        TextView tvNotice;
        TextView tvDate;
        //TextView tvMsg;
        ImageView iv;

        VH(View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tv_name);
            tvInfo=itemView.findViewById(R.id.tv_info);
            tvHref=itemView.findViewById(R.id.tv_href);
            tvNotice=itemView.findViewById(R.id.tv_notice);
            tvDate=itemView.findViewById(R.id.tv_date);
            //tvMsg=itemView.findViewById(R.id.tv_msg);
            iv=itemView.findViewById(R.id.iv);

            //tvDate.setVisibility(View.VISIBLE);

        }
    }
}