package mod;

import static com.besome.sketch.SketchApplication.getContext;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.Random;

import a.a.a.bB;
import mod.jbk.util.LogUtil;

public class SketchwareUtil {

    public static boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * @param v A View which should be visible and "connected" to the currently focused view
     * @see SketchwareUtil#hideKeyboard()
     */
    public static void hideKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /**
     * Hide the keyboard. This may show the keyboard if it's not opened.
     * Use {@link SketchwareUtil#hideKeyboard(View)} instead, if possible.
     *
     * @see SketchwareUtil#hideKeyboard(View)
     */
    public static void hideKeyboard() {
        InputMethodManager _inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        _inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * @param v A View which should be focused (and wants to receive IME input)
     */
    public static void showKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(v, 0);
    }

    /**
     * Use {@link SketchwareUtil#showKeyboard(View)} instead, if possible.
     */
    public static void showKeyboard() {
        InputMethodManager _inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        _inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public static void showMessage(Context context, String _s) {
        Toast.makeText(context, _s, Toast.LENGTH_SHORT).show();
    }

    public static int getRandom(int _min, int _max) {
        return new Random().nextInt(_max - _min + 1) + _min;
    }

    public static float getDip(int input) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, input, getContext().getResources().getDisplayMetrics());
    }

    /**
     * Show a Toast styled Sketchware-like.
     *
     * @param message The message to toast
     * @param length  The toast's length, either {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}
     */
    public static void toast(String message, int length) {
        try {
            bB.a(getContext(), message, length).show();
        } catch (RuntimeException e) {
            LogUtil.e("SketchwareUtil", "Failed to toast regular message, " +
                    "Toast's message was: \"" + message + "\"", e);
        }
    }

    /**
     * Show a Toast styled Sketchware-like and with length {@link Toast#LENGTH_SHORT}.
     *
     * @param message The message to toast
     */
    public static void toast(String message) {
        toast(message, Toast.LENGTH_SHORT);
    }

    /**
     * Show an error Toast styled Sketchware-like and with length {@link Toast#LENGTH_SHORT}.
     *
     * @param message The message to toast
     * @param length  The toast's length, either {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}
     */
    public static void toastError(String message, int length) {
        try {
            bB.b(getContext(), message, length).show();
        } catch (RuntimeException e) {
            LogUtil.e("SketchwareUtil", "Failed to toast regular message, " +
                    "Toast's message was: \"" + message + "\"", e);
        }
    }

    /**
     * Show an error Toast styled Sketchware-like and with length {@link Toast#LENGTH_SHORT}.
     *
     * @param message The message to toast
     */
    public static void toastError(String message) {
        toastError(message, Toast.LENGTH_SHORT);
    }

    /**
     * Converts dps into pixels.
     *
     * @param dp The amount of density-independent pixels to convert
     * @return {@code dp} in pixels
     */
    public static int dpToPx(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources().getDisplayMetrics());
    }

}