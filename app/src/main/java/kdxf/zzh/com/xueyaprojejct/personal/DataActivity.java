package kdxf.zzh.com.xueyaprojejct.personal;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.User;
import kdxf.zzh.com.xueyaprojejct.customview.MyDialog;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/11.
 */

public class DataActivity extends BaseActivity implements View.OnClickListener {
    private String[] srt = {"男", "女"};
    private String Sex = "";
    private RelativeLayout re_birthday;
    private RelativeLayout re_weight;
    private RelativeLayout re_hight;
    private RelativeLayout re_sex;
    private RelativeLayout re_name;
    private ImageView iv_back;
    private TextView tv_choose1;
    private User user;
    private List<String> list;
    private String[] strings;
    private TextView tv_choose2;
    private TextView tv_choose3;
    private TextView tv_choose4;
    private String[] strings1;
    private List<String> list1;
    private ImageView iv;
    private TextView tv_choose;

    @Override
    public int initLayout() {
        return R.layout.activity_data;
    }

    @Override
    public void initView() {
        iv_back=findViewById( R.id.iv_back );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "个人资料" );
        re_name = findViewById( R.id.re_name );
        re_sex = findViewById( R.id.re_sex );
        re_hight = findViewById( R.id.re_hight );
        re_weight = findViewById( R.id.re_weight );
        re_birthday = findViewById( R.id.re_birthday );
        list = new ArrayList<>(  );
        iv = findViewById( R.id.iv );
        tv_choose = findViewById( R.id.tv_choose );
        tv_choose1 = findViewById( R.id.tv_choose1 );
        tv_choose2 = findViewById( R.id.tv_choose2 );
        tv_choose3 = findViewById( R.id.tv_choose3 );
        tv_choose4 = findViewById( R.id.tv_choose4 );

        for (int i=40;i<200;i++){
            list.add( i+"" );
        }
        strings = list.toArray(new String[list.size()]);
        list1 = new ArrayList<>(  );
        for (int i=2;i<100;i++){
            list1.add( i+"" );
        }
        strings1 = list1.toArray(new String[list1.size()]);
    }

    @Override
    public void initClick() {
        re_name.setOnClickListener( this );
        re_sex.setOnClickListener( this );
        re_hight.setOnClickListener( this );
        re_weight.setOnClickListener( this );
        re_birthday.setOnClickListener( this );
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {
        user = Config.getUser( DataActivity.this );
        tv_choose.setText( user.getAccountstr());
        tv_choose1.setText( user.getSex() );
        tv_choose2.setText( user.getHeight()+"");
//        tv_choose3.setText( user.getWeight());
        tv_choose4.setText( user.getBirthday());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.re_name:
                enterActivity( NameActivity.class );
                break;
            case R.id.re_sex:
                showSexDialog();
                break;
            case R.id.re_hight:
                showHightDialog();
                break;
            case R.id.re_weight:
                showWeightDialog();
                break;
            case R.id.re_birthday:
                showDatePickerDialog();
                break;

        }
    }
    /* 性别 */
    private void showSexDialog() {
        final MyDialog myDialog = new MyDialog(DataActivity.this,
                R.style.MyDialogStyle);
        myDialog.show();
        myDialog.setCancelable(false);//按返回键可dismiss
        myDialog.setCanceledOnTouchOutside(false);//点击dialog以外不会消失
        myDialog.setContentView(R.layout.test_act );
        TextView dialogTitle = myDialog
                .findViewById(R.id.mydialog_title);
        dialogTitle.setText("设置性别");
        NumberPicker numberPicker =  myDialog
                .findViewById(R.id.picker);
        // numberPicker.setFormatter(this);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                tv_choose1.setText(srt[newVal]);
                if("男".equals(srt[newVal])){
                    Sex="1";
                }else{
                    Sex="2";
                }


            }
        });
//         numberPicker.setOnScrollListener(this);
        numberPicker.setDisplayedValues(srt);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(srt.length - 1);
        TextView leftButton = myDialog
                .findViewById(R.id.mydialog_twobutton_layout_left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                myDialog.dismiss();
            }
        });
        leftButton.setVisibility(View.GONE);
        myDialog.findViewById(R.id.mydialog_twobutton_layout_right_button)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        myDialog.dismiss();
                       updata();
                    }
                });

    }
    /* 身高 */
    private void showHightDialog() {
        final MyDialog myDialog = new MyDialog(DataActivity.this,
                R.style.MyDialogStyle);
        myDialog.setCancelable(false);//按返回键可dismiss
        myDialog.setCanceledOnTouchOutside(false);//点击dialog以外不会消失
        myDialog.setContentView(R.layout.test_act );
        TextView dialogTitle = myDialog
                .findViewById(R.id.mydialog_title);
        dialogTitle.setText("选择身高");
        NumberPicker numberPicker =  myDialog
                .findViewById(R.id.picker);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv_choose2.setText(strings[newVal]);


            }
        });
        numberPicker.setDisplayedValues(strings);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(strings.length - 1);
        TextView leftButton = myDialog
                .findViewById(R.id.mydialog_twobutton_layout_left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                myDialog.dismiss();
            }
        });
        leftButton.setVisibility(View.GONE);
        myDialog.findViewById(R.id.mydialog_twobutton_layout_right_button)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        myDialog.dismiss();
                        updata();
                    }
                });
        myDialog.show();
    }
    /* 体重 */
    private void showWeightDialog() {
        final MyDialog myDialog = new MyDialog(DataActivity.this,
                R.style.MyDialogStyle);
        myDialog.setCancelable(false);//按返回键可dismiss
        myDialog.setCanceledOnTouchOutside(false);//点击dialog以外不会消失
        myDialog.setContentView(R.layout.test_act );
        TextView dialogTitle = myDialog
                .findViewById(R.id.mydialog_title);
        dialogTitle.setText("选择身高");
        NumberPicker numberPicker =  myDialog
                .findViewById(R.id.picker);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv_choose3.setText(strings1[newVal]);


            }
        });
        numberPicker.setDisplayedValues(strings1);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(strings1.length - 1);
        TextView leftButton = myDialog
                .findViewById(R.id.mydialog_twobutton_layout_left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                myDialog.dismiss();
            }
        });
        leftButton.setVisibility(View.GONE);
        myDialog.findViewById(R.id.mydialog_twobutton_layout_right_button)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        myDialog.dismiss();
                        updata();
                    }
                });
        myDialog.show();
    }
    /* 时间 */
    public void showDatePickerDialog() {
        System.out.println("showDatePickerDialog---");
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        String str = user.getBirthday();
        if (!TextUtils.isEmpty(str)) {
            mYear = Integer.parseInt(str.substring(0, 4));
            mMonth = Integer.parseInt(str.substring(5, 7));
            mMonth = mMonth - 1;
            mDay = Integer
                    .parseInt(str.substring(Math.max(str.length() - 2, 0)));
        }

        //系统提供的
        DatePickerDialog dialog = new DatePickerDialog(DataActivity.this, DatePickerDialog.THEME_HOLO_LIGHT,mDateSetListener,
                mYear, mMonth, mDay);
        dialog.show();

    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            monthOfYear = monthOfYear + 1;
            String birthday = "";
            if (monthOfYear < 10) {
                birthday = year + "-0" + monthOfYear + "-" + dayOfMonth;
                tv_choose4.setText(birthday);
            } else {
                birthday = year + "-" + monthOfYear + "-" + dayOfMonth;
                tv_choose4.setText(birthday);
            }
            user.setBirthday(birthday);

               updata();

        }
    };


    private void updata() {
        String url= Config.getUrl( "kbb","resetProperty" );
        Map<String,String> map=new HashMap<>(  );
        map.put("userid",user.getUserid());
        map.put("app_id",2+"");
        map.put("accountstr",user.getAccountstr());
        map.put("test", Sex);
        map.put("height",user.getHeight()+"");
        if(user.getBirthday().isEmpty()){
            map.put("birthday","0");
        }else{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date time= null;
            try {
                time = format.parse(user.getBirthday());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            map.put("birthday",time.getTime()/1000+"");
        }
        map.put("keyword", "edit");
        OkHttpUtils.getInstance().post( url, map, new RequestCallBack<String>() {
            @Override
            public void sucess(Call call, String t) {
            }
            @Override
            public void fail(Call call, IOException e) {
            }
        } );
    }
}
