package com.digital.nftu.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import kotlin.math.round

fun Boolean?.orFalse(): Boolean = this ?: false

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0L

fun Float?.orZero(): Float = this ?: 0f

fun Double?.orZero(): Double = this ?: 0.0

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}

fun String?.equalsIgnoreCase(other: String?): Boolean {
    return equals(other, true)
}

fun String?.containsIgnoreCase(other: String?): Boolean {
    if (this == null || other == null) return false

    return contains(other, true)
}

fun Context?.dimenSize(@DimenRes dimenRes: Int): Int {
    return this?.resources?.getDimensionPixelSize(dimenRes) ?: 0
}

fun Context?.compatColor(@ColorRes colorRes: Int): Int {
    this ?: return Color.TRANSPARENT

    return ResourcesCompat.getColor(resources, colorRes, theme)
}

fun Context?.attrColor(@AttrRes attrRes: Int): Int {
    this ?: return Color.TRANSPARENT

    val typedValue = TypedValue()
    theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.data
}

fun Context.showShortToast(@StringRes message: Int) {
    showShortToast(getString(message))
}

fun Context.showShortToast(message: String?) {
    if (message.isNullOrBlank()) {
        return
    }
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(@StringRes message: Int) {
    showLongToast(getString(message))
}

fun Context.showLongToast(message: String?) {
    if (message.isNullOrBlank()) {
        return
    }

    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.invisible(): View {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
    return this
}

inline fun View.invisibleIf(condition: () -> Boolean): View {
    if (visibility != View.INVISIBLE && condition()) {
        visibility = View.INVISIBLE
    }
    return this
}

fun View.gone(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

fun View.setVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

inline fun View.goneIf(predicate: () -> Boolean): View {
    if (visibility != View.GONE && predicate()) {
        visibility = View.GONE
    }
    return this
}

fun Any?.isNull() = this == null

fun Activity.hideSoftKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(findViewById<View>(android.R.id.content).windowToken, 0)
}

