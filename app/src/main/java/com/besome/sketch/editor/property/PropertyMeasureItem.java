package com.besome.sketch.editor.property;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sketchware.remod.Resources;

import a.a.a.Kw;
import a.a.a.TB;
import a.a.a.aB;
import a.a.a.mB;
import a.a.a.sq;
import a.a.a.wB;
import a.a.a.xB;
import mod.hey.studios.util.Helper;

public class PropertyMeasureItem extends RelativeLayout implements View.OnClickListener {

    private String key = "";
    private int measureValue = -1;
    private TextView tvName;
    private TextView tvValue;
    private ImageView imgLeftIcon;
    private View propertyItem;
    private View propertyMenuItem;
    private Kw listener;
    private boolean isMatchParent = true;
    private boolean isWrapContent = true;
    private boolean isCustomValue = true;
    private int imgLeftIconDrawableResId;

    public PropertyMeasureItem(Context context, boolean z) {
        super(context);
        a(context, z);
    }

    private void setIcon(ImageView imageView) {
        if (key.equals("property_layout_width")) {
            imgLeftIconDrawableResId = Resources.drawable.width_96;
        } else if (key.equals("property_layout_height")) {
            imgLeftIconDrawableResId = Resources.drawable.height_96;
        }
        imageView.setImageResource(imgLeftIconDrawableResId);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
        int identifier = getResources().getIdentifier(key, "string", getContext().getPackageName());
        if (identifier > 0) {
            tvName.setText(xB.b().a(getResources(), identifier));
            if (this.propertyMenuItem.getVisibility() == VISIBLE) {
                setIcon(findViewById(Resources.id.img_icon));
                ((TextView) findViewById(Resources.id.tv_title)).setText(xB.b().a(getContext(), identifier));
                return;
            }
            setIcon(imgLeftIcon);
        }
    }

    public int getValue() {
        return measureValue;
    }

    public void setValue(int value) {
        measureValue = value;
        if (!isWrapContent && value == LayoutParams.WRAP_CONTENT) {
            tvValue.setText(sq.a(key, LayoutParams.MATCH_PARENT));
        } else if (isCustomValue || value < 0) {
            tvValue.setText(sq.a(key, value));
        } else {
            tvValue.setText(sq.a(key, LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void onClick(View v) {
        if (!mB.a()) {
            a();
        }
    }

    public void setItemEnabled(int itemEnabled) {
        isMatchParent = (itemEnabled & 1) == 1;
        isWrapContent = (itemEnabled & 2) == 2;
        isCustomValue = (itemEnabled & 4) == 4;
    }

    public void setOnPropertyValueChangeListener(Kw kw) {
        listener = kw;
    }

    public void setOrientationItem(int orientationItem) {
        if (orientationItem == 0) {
            propertyItem.setVisibility(GONE);
            propertyMenuItem.setVisibility(VISIBLE);
        } else {
            propertyItem.setVisibility(VISIBLE);
            propertyMenuItem.setVisibility(GONE);
        }
    }

    public final void a(Context context, boolean z) {
        wB.a(context, this, Resources.layout.property_selector_item);
        tvName = findViewById(Resources.id.tv_name);
        tvValue = findViewById(Resources.id.tv_value);
        imgLeftIcon = findViewById(Resources.id.img_left_icon);
        propertyItem = findViewById(Resources.id.property_item);
        propertyMenuItem = findViewById(Resources.id.property_menu_item);
        if (z) {
            setOnClickListener(this);
            setSoundEffectsEnabled(true);
        }
    }

    public final void a() {
        aB dialog = new aB((Activity) getContext());
        dialog.b(tvName.getText().toString());
        dialog.a(imgLeftIconDrawableResId);

        View view = wB.a(getContext(), Resources.layout.property_popup_measurement);
        EditText ed_input = view.findViewById(Resources.id.ed_input);
        RadioGroup rg_width_height = view.findViewById(Resources.id.rg_width_height);
        TB tb = new TB(getContext(), view.findViewById(Resources.id.ti_input), 0, 999);

        RadioButton rb_matchparent = view.findViewById(Resources.id.rb_matchparent);
        View tv_matchparent = view.findViewById(Resources.id.tv_matchparent);
        RadioButton rb_wrapcontent = view.findViewById(Resources.id.rb_wrapcontent);
        TextView tv_wrapcontent = view.findViewById(Resources.id.tv_wrapcontent);
        RadioButton rb_directinput = view.findViewById(Resources.id.rb_directinput);
        View direct_input = view.findViewById(Resources.id.direct_input);
        TextView tv_input_dp = view.findViewById(Resources.id.tv_input_dp);

        rg_width_height.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == Resources.id.rb_directinput) {
                ed_input.setEnabled(true);
                tb.a(ed_input.getText().toString());
            } else {
                ed_input.setEnabled(false);
            }
        });
        ed_input.setEnabled(false);
        rg_width_height.clearCheck();
        if (measureValue >= 0) {
            if (isCustomValue) {
                rg_width_height.check(Resources.id.rb_directinput);
                ed_input.setEnabled(true);
                tb.a(String.valueOf(measureValue));
            } else {
                rg_width_height.check(Resources.id.rb_wrapcontent);
            }
        } else if (measureValue == LayoutParams.MATCH_PARENT) {
            rg_width_height.check(Resources.id.rb_matchparent);
        } else if (isWrapContent) {
            rg_width_height.check(Resources.id.rb_wrapcontent);
        } else {
            rg_width_height.check(Resources.id.rb_matchparent);
        }
        tv_matchparent.setOnClickListener(v -> rb_matchparent.setChecked(true));
        if (isWrapContent) {
            rb_matchparent.setEnabled(true);
            tv_wrapcontent.setClickable(true);
            tv_wrapcontent.setTextColor(0xff757575);
            tv_wrapcontent.setOnClickListener(v -> rb_wrapcontent.setChecked(true));
        } else {
            rb_matchparent.setEnabled(false);
            tv_wrapcontent.setClickable(false);
            tv_wrapcontent.setTextColor(0xffdddddd);
        }
        if (isCustomValue) {
            rb_directinput.setEnabled(true);
            direct_input.setClickable(true);
            tv_input_dp.setTextColor(0xff757575);
            direct_input.setOnClickListener(v -> rb_directinput.setChecked(true));
        } else {
            rb_directinput.setEnabled(false);
            direct_input.setClickable(false);
            tv_input_dp.setTextColor(0xffdddddd);
        }
        dialog.a(view);
        dialog.b(xB.b().a(getContext(), Resources.string.common_word_select), v -> {
            int checkedRadioButtonId = rg_width_height.getCheckedRadioButtonId();

            if (checkedRadioButtonId == Resources.id.rb_matchparent) {
                setValue(LayoutParams.MATCH_PARENT);
            } else if (checkedRadioButtonId == Resources.id.rb_wrapcontent) {
                setValue(LayoutParams.WRAP_CONTENT);
            } else if (tb.b()) {
                setValue(Integer.parseInt(ed_input.getText().toString()));
            } else {
                return;
            }
            if (listener != null) {
                listener.a(key, measureValue);
            }
            dialog.dismiss();
        });
        dialog.a(xB.b().a(getContext(), Resources.string.common_word_cancel),
                Helper.getDialogDismissListener(dialog));
        dialog.show();
    }
}