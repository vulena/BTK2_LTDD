package com.ltdd.bktso2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListView listView;
    ArrayList<Member> items = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list_view);
        items.add(new Member("Paracetamon","Thuốc đau đầu", "Bột kết tinh trắng ,không màu" ,"Công dụng:trị đau đầu"," Liều chung: 325 - 650mg/ liều cách 4-6 giờ hoặc 1000mg cách 6-8 giờ bằng đường uống hoặc đặt hậu môn","Luu ý: Nếu sử dụng viên nén Paracetamol 500mg: 1–2 viên/liều uống cách nhau 4-6 giờ.",R.drawable.thuoc_para)) ;
        items.add(new Member("acid acetylsalicylic","Aspirin", "Bột kết tinh trắng ,không màu","Công dụng:hạ sốt","Giảm đau, hạ sốt: Uống 300 – 900 mg. Lặp lại liều sau mỗi 4 – 6 giờ nếu cần. Liều tối đa: 4 g/ngày.","Không dùng khi dị ứng với các thành phần nào của thuốc ",R.drawable.thuoc_apirin)) ;
        items.add(new Member("Paracetamon","Thuốc đau đầu", "Bột kết tinh trắng ,không màu" ,"Công dụng:trị đau đầu"," Liều chung: 325 - 650mg/ liều cách 4-6 giờ hoặc 1000mg cách 6-8 giờ bằng đường uống hoặc đặt hậu môn","Luu ý: Nếu sử dụng viên nén Paracetamol 500mg: 1–2 viên/liều uống cách nhau 4-6 giờ.",R.drawable.thuoc_para)) ;
        items.add(new Member("Viaga","Thuốc đau đầu", "Bột kết tinh trắng ,không màu" ,"Công dụng:trị đau đầu"," Liều chung: 325 - 650mg/ liều cách 4-6 giờ hoặc 1000mg cách 6-8 giờ bằng đường uống hoặc đặt hậu môn","Luu ý: Nếu sử dụng viên nén Paracetamol 500mg: 1–2 viên/liều uống cách nhau 4-6 giờ.",R.drawable.anhthuoc)) ;
        adapter = new Adapter(List.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(List.this,Detail.class);
                intent.putExtra("Ten",items.get(i).getTenkhoahoc()+"\n"+items.get(i).getTenthuonggoi());
                intent.putExtra("MoTa",items.get(i).getDactinh());
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(List.this,Detail.class);
                intent.putExtra("Ten",items.get(i).getTenkhoahoc()+"\n"+items.get(i).getTenthuonggoi());
                intent.putExtra("MoTa",items.get(i).getDactinh());
                intent.putExtra("hinhanh",items.get(i).getHinhAnh());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Xacnhanxoa(i);
                return true;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(List.this);
        alertDiaLog.setTitle("Thông báo");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDiaLog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.headmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuadd:
                addCa();
                break;
            case R.id.menuexit:
                break;
        }
        return true;
    }
    private void addCa() {
        Dialog dialog = new Dialog(List.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogthemcacustom);
        dialog.show();
        TextView tv1 = (TextView) dialog.findViewById(R.id.isTenKH);
        TextView tv2 = (TextView) dialog.findViewById(R.id.isTentg);
        TextView tv3 = (TextView) dialog.findViewById(R.id.isMausac);
        TextView tv4 = (TextView) dialog.findViewById(R.id.dactinh);
        TextView tv5 = (TextView) dialog.findViewById(R.id.lieudung);
        TextView tv6 = (TextView) dialog.findViewById(R.id.luuy);

        Button btok = (Button) dialog.findViewById(R.id.btn_okC);
        Button btcancel = (Button) dialog.findViewById(R.id.btn_cancelC);
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString(),tv4.getText().toString(),tv5.getText().toString(),tv6.getText().toString(),R.drawable.ic_launcher_background);
                items.add(member);
                adapter.notifyDataSetChanged();
                dialog.cancel();
            }
        });
        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }
}