package dev.aldi.sayuti.editor.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;

import com.besome.sketch.beans.ProjectResourceBean;
import com.besome.sketch.beans.ViewBean;
import com.besome.sketch.editor.view.ViewPane;

import java.util.ArrayList;
import java.util.Arrays;

import a.a.a.bB;
import a.a.a.kC;
import dev.aldi.sayuti.editor.view.item.ItemCircleImageView;

public class ExtraViewPane {
    public static void a(View view, ViewBean viewBean, ViewPane viewPane, kC kCVar) {
        switch (getLastPath(viewBean.convert)) {
            case "SearchView":
                a((EditText) view, viewBean);
                break;

            case "AutoCompleteTextView":
                b((AutoCompleteTextView) view, viewBean);
                break;

            case "MultiAutoCompleteTextView":
                c((MultiAutoCompleteTextView) view, viewBean);
                break;

            case "CircleImageView":
                if (viewBean.type == 43) {
                    d((ItemCircleImageView) view, viewBean, viewPane, kCVar);
                }
                break;
        }
    }

    public static void a(EditText editText, ViewBean viewBean) {
        editText.setHint(viewBean.text.hint);
        editText.setHintTextColor(viewBean.text.hintColor);
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131166060, 0);
    }

    public static void b(AutoCompleteTextView autoCompleteTextView, ViewBean viewBean) {
        autoCompleteTextView.setHint(viewBean.text.hint);
        autoCompleteTextView.setHintTextColor(viewBean.text.hintColor);
    }

    public static void c(MultiAutoCompleteTextView multiAutoCompleteTextView, ViewBean viewBean) {
        multiAutoCompleteTextView.setHint(viewBean.text.hint);
        multiAutoCompleteTextView.setHintTextColor(viewBean.text.hintColor);
    }

    public static void d(ItemCircleImageView itemCircleImageView, ViewBean viewBean, ViewPane viewPane, kC kCVar) {
        if (kCVar.h(viewBean.image.resName) == ProjectResourceBean.PROJECT_RES_TYPE_RESOURCE) {
            itemCircleImageView.setImageResource(viewPane.getContext().getResources().getIdentifier(viewBean.image.resName, "drawable", viewPane.getContext().getPackageName()));
        } else if (viewBean.image.resName.equals("default_image")) {
            itemCircleImageView.setImageResource(2131165522);
        } else {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(kCVar.f(viewBean.image.resName));
                int round = Math.round(viewPane.getResources().getDisplayMetrics().density / 2.0f);
                itemCircleImageView.setImageBitmap(Bitmap.createScaledBitmap(decodeFile, decodeFile.getWidth() * round, round * decodeFile.getHeight(), true));
            } catch (Exception e) {
                itemCircleImageView.setImageResource(2131165522);
            }
        }
        itemCircleImageView.setScaleType(ImageView.ScaleType.valueOf("CENTER_CROP"));
        for (String splitLine : new ArrayList<>(Arrays.asList(viewBean.inject.split("\n")))) {
            if (splitLine.contains("border_color")) {
                splitLine = splitLine.replaceAll("app:civ_border_color=\"|\"", "");
                try {
                    itemCircleImageView.setBorderColor(Color.parseColor(splitLine));
                } catch (Exception e2) {
                    itemCircleImageView.setBorderColor(Color.parseColor("#FF008DCD"));
                    bB.a(viewPane.getContext(), "Invalid border color!", 0).show();
                }
            }
            if (splitLine.contains("background_color")) {
                splitLine = splitLine.replaceAll("app:civ_circle_background_color=\"|\"", "");
                try {
                    itemCircleImageView.setCircleBackgroundColor(Color.parseColor(splitLine));
                } catch (Exception e3) {
                    itemCircleImageView.setBorderColor(Color.parseColor("#FF008DCD"));
                    bB.a(viewPane.getContext(), "Invalid backgroud color!", 0).show();
                }
            }
            if (splitLine.contains("border_width")) {
                try {
                    itemCircleImageView.setBorderWidth(Integer.parseInt(splitLine.replaceAll("app:civ_border_width=\"|dp\"", "")));
                } catch (Exception e4) {
                    itemCircleImageView.setBorderWidth(3);
                }
            }
        }
    }

    public static String getLastPath(String str) {
        if (!str.contains(".")) {
            return str;
        }
        String[] split = str.split("\\.");
        return split[split.length - 1];
    }
}
