package com.besome.sketch.editor.manage.library.admob;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.besome.sketch.beans.AdTestDeviceBean;
import com.besome.sketch.beans.ProjectLibraryBean;
import com.besome.sketch.lib.base.BaseSessionAppCompatActivity;
import com.sketchware.remod.R;

import java.util.ArrayList;

import a.a.a.DB;
import a.a.a.GB;
import a.a.a.aB;
import a.a.a.bB;
import a.a.a.mB;
import mod.hey.studios.util.Helper;

public class ManageAdmobActivity extends BaseSessionAppCompatActivity implements View.OnClickListener {

    private DB A = null;
    private TestDeviceAdapter testDeviceAdapter;
    private ArrayList<AdTestDeviceBean> testDeviceList = new ArrayList<>();
    private Switch libSwitch;
    private TextView tvBannerName;
    private TextView tvBannerId;
    private TextView tvInterName;
    private TextView tvInterId;
    private ProjectLibraryBean admobLibraryBean;
    private final int n = 8001;
    private final int o = 8002;

    @Override
    public void a(int requestCode, String idk) {
        if (requestCode == 8001 || requestCode == 8002) {
            n(requestCode);
        }
    }

    private void initializeLibrary(ProjectLibraryBean libraryBean) {
        admobLibraryBean = libraryBean;
        configure();
    }

    private void setBannerAdUnit(String adId) {
        if (!adId.isEmpty()) {
            if (adId.contains(" : ")) {
                int indexOfSemicolon = adId.indexOf(" : ");
                tvBannerName.setText(adId.substring(0, indexOfSemicolon));
                tvBannerId.setText(adId.substring(indexOfSemicolon + 3));
            } else {
                tvBannerName.setText("");
                tvBannerId.setText(adId);
            }
        }
    }

    private void setInterAdUnit(String adId) {
        if (!adId.isEmpty()) {
            if (adId.contains(" : ")) {
                int indexOfSemicolon = adId.indexOf(" : ");
                tvInterName.setText(adId.substring(0, indexOfSemicolon));
                tvInterId.setText(adId.substring(indexOfSemicolon + 3));
            } else {
                tvInterName.setText("");
                tvInterId.setText(adId);
            }
        }
    }

    @Override
    public void g(int idk) {
    }

    @Override
    public void h(int idk) {
    }

    @Override
    public void l() {
    }

    @Override
    public void m() {
    }

    private void n() {
        if (GB.h(getApplicationContext())) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("https://apps.admob.com/v2/home"));
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                downloadChromeDialog();
            }
        } else {
            bB.a(getApplicationContext(), Helper.getResString(R.string.common_message_check_network), bB.TOAST_NORMAL).show();
        }
    }

    private void n(int requestCode) {
        if (requestCode == 8001) {
            libSwitch.setChecked(true);
            admobLibraryBean.useYn = "Y";
        } else {
            toAdmobActivity();
        }
    }

    private void o() {
        try {
            A.a("P1I16", true);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("https://docs.sketchware.io/docs/admob-getting-started.html"));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            startActivity(intent);
        } catch (Exception e) {
            downloadChromeDialog();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 236:
                    initializeLibrary(data.getParcelableExtra("admob"));
                    break;
                case 8001:
                    libSwitch.setChecked(true);
                    admobLibraryBean.useYn = "Y";
                    break;
                case 8002:
                    toAdmobActivity();
                    break;
            }
        }
    }

    public void onBackPressed() {
        getIntent().putExtra("admob", admobLibraryBean);
        setResult(RESULT_OK, getIntent());
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        if (!mB.a()) {
            int id = v.getId();
            if (id == R.id.btn_console) {
                n();
            } else if (id == R.id.layout_switch) {
                if (!libSwitch.isChecked()) {
                    i(8001);
                } else {
                    libSwitch.setChecked(!libSwitch.isChecked());
                    if ("Y".equals(admobLibraryBean.useYn) && !libSwitch.isChecked()) {
                        configureLibrary();
                    } else {
                        admobLibraryBean.useYn = "Y";
                    }
                }
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_library_manage_admob);

        Toolbar toolbar = findViewById(R.id.toolbar);
        a(toolbar);
        findViewById(R.id.layout_main_logo).setVisibility(View.GONE);
        d().a(Helper.getResString(R.string.design_library_admob_title_admob_manager));
        d().e(true);
        d().d(true);
        toolbar.setNavigationOnClickListener(Helper.getBackPressedClickListener(this));

        A = new DB(this.getApplicationContext(), "P1");
        admobLibraryBean = getIntent().getParcelableExtra("admob");
        ((TextView) findViewById(R.id.tv_enable)).setText(Helper.getResString(R.string.design_library_settings_title_enabled));
        ((TextView) findViewById(R.id.tv_title_banner)).setText(Helper.getResString(R.string.design_library_admob_title_banner));
        ((TextView) findViewById(R.id.tv_title_banner_name)).setText(Helper.getResString(R.string.design_library_admob_title_ad_name) + " : ");
        ((TextView) findViewById(R.id.tv_title_banner_id)).setText(Helper.getResString(R.string.design_library_admob_title_ad_unit_id) + " : ");
        ((TextView) findViewById(R.id.tv_title_inter)).setText(Helper.getResString(R.string.design_library_admob_title_interstitial));
        ((TextView) findViewById(R.id.tv_title_inter_name)).setText(Helper.getResString(R.string.design_library_admob_title_ad_name) + " : ");
        ((TextView) findViewById(R.id.tv_title_inter_id)).setText(Helper.getResString(R.string.design_library_admob_title_ad_unit_id) + " : ");
        ((TextView) findViewById(R.id.tv_title_test_device)).setText(Helper.getResString(R.string.design_library_admob_dialog_set_test_device_title));
        tvBannerId = findViewById(R.id.tv_banner_id);
        tvBannerName = findViewById(R.id.tv_banner_name);
        tvInterId = findViewById(R.id.tv_inter_id);
        tvInterName = findViewById(R.id.tv_inter_name);

        RecyclerView listTestDevice = findViewById(R.id.list_test_device);
        listTestDevice.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        testDeviceAdapter = new TestDeviceAdapter();
        listTestDevice.setAdapter(testDeviceAdapter);

        libSwitch = findViewById(R.id.lib_switch);
        LinearLayout switchLayout = findViewById(R.id.layout_switch);
        switchLayout.setOnClickListener(this);

        Button btnConsole = findViewById(R.id.btn_console);
        btnConsole.setText(Helper.getResString(R.string.design_library_admob_button_goto_console));
        btnConsole.setOnClickListener(this);

        configure();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manage_admob_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_admob_help) {
            o();
        } else if (itemId == R.id.menu_admob_settings) {
            i(8002);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void configureLibrary() {
        final aB dialog = new aB(this);
        dialog.a(R.drawable.delete_96);
        dialog.b(Helper.getResString(R.string.common_word_warning));
        dialog.a(Helper.getResString(R.string.design_library_admob_dialog_description_confirm_uncheck));
        dialog.setCancelable(false);
        dialog.b(Helper.getResString(R.string.common_word_delete), v -> {
            if (!mB.a()) {
                admobLibraryBean.useYn = "N";
                libSwitch.setChecked(false);
                dialog.dismiss();
            }
        });
        dialog.a(Helper.getResString(R.string.common_word_cancel), Helper.getDialogDismissListener(dialog));
        dialog.show();
    }

    private void downloadChromeDialog() {
        final aB dialog = new aB(this);
        dialog.a(R.drawable.chrome_96);
        dialog.b(Helper.getResString(R.string.title_compatible_chrome_browser));
        dialog.a(Helper.getResString(R.string.message_compatible_chrome_brower));
        dialog.b(Helper.getResString(R.string.common_word_ok), v -> {
            if (!mB.a()) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.android.chrome"));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog.a(Helper.getResString(R.string.common_word_cancel), Helper.getDialogDismissListener(dialog));
        dialog.show();
    }

    private void toAdmobActivity() {
        Intent intent = new Intent(getApplicationContext(), AdmobActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("admob", admobLibraryBean);
        startActivityForResult(intent, 236);
    }

    private void configure() {
        libSwitch.setChecked("Y".equals(admobLibraryBean.useYn));
        setBannerAdUnit(admobLibraryBean.reserved1);
        setInterAdUnit(admobLibraryBean.reserved2);
        testDeviceList = admobLibraryBean.testDevices;
        testDeviceAdapter.c();
    }

    public class TestDeviceAdapter extends RecyclerView.a<TestDeviceAdapter.ViewHolder> {

        @Override
        public int a() {
            return testDeviceList.size();
        }

        @Override
        public void b(ViewHolder viewHolder, int index) {
            viewHolder.tvDeviceId.setText(testDeviceList.get(index).deviceId);
        }

        @Override
        public ViewHolder b(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.manage_library_setting_admob_test_device_item, parent, false));
        }

        public class ViewHolder extends RecyclerView.v {

            private final TextView tvDeviceId;

            public ViewHolder(View view) {
                super(view);
                tvDeviceId = view.findViewById(R.id.tv_device_id);
                ImageView imgDelete = view.findViewById(R.id.img_delete);

                imgDelete.setVisibility(View.GONE);
            }
        }
    }
}
