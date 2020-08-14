package com.licheedev.labelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LabelTextView extends ConstraintLayout {

    public final ImageView icon;
    public final TextView label;
    public final TextView value;

    public LabelTextView(Context context) {
        this(context, null);
    }

    public LabelTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        int layoutId = R.layout.label_text_view_default_layout;
        int iconId = R.id.iv_icon;
        int labelId = R.id.tv_label;
        int valueId = R.id.tv_value;

        int iconDrawable = 0;
        String labelString = null;
        String valueString = null;

        int[] VISIBILITY = { View.VISIBLE, View.INVISIBLE, View.GONE };
        
        int iconVisibility = VISIBILITY[0];
        int labelVisibility = VISIBILITY[0];
        int valueVisibility = VISIBILITY[0];

        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LabelTextView);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.LabelTextView_override_layout) {
                    layoutId = a.getResourceId(attr, layoutId);
                } else if (attr == R.styleable.LabelTextView_override_label_id) {
                    labelId = a.getResourceId(attr, labelId);
                } else if (attr == R.styleable.LabelTextView_override_value_id) {
                    valueId = a.getResourceId(attr, valueId);
                } else if (attr == R.styleable.LabelTextView_override_icon_id) {
                    iconId = a.getResourceId(attr, iconId);
                } else if (attr == R.styleable.LabelTextView_label_visibility) {
                    labelVisibility = a.getInt(attr, 0);
                } else if (attr == R.styleable.LabelTextView_value_visibility) {
                    valueVisibility = a.getInt(attr, 0);
                } else if (attr == R.styleable.LabelTextView_icon_visibility) {
                    iconVisibility = a.getInt(attr, 0);
                } else if (attr == R.styleable.LabelTextView_label_text) {
                    labelString = a.getString(attr);
                } else if (attr == R.styleable.LabelTextView_value_text) {
                    valueString = a.getString(attr);
                } else if (attr == R.styleable.LabelTextView_icon_drawable) {
                    iconDrawable = a.getResourceId(attr, 0);
                }
            }
            a.recycle();
        }

        LayoutInflater.from(context).inflate(layoutId, this, true);
        this.label = findViewById(labelId);
        this.value = findViewById(valueId);
        this.icon = findViewById(iconId);

        setViewVisibility(this.label, VISIBILITY[labelVisibility]);
        setViewVisibility(this.value, VISIBILITY[valueVisibility]);
        setViewVisibility(this.icon, VISIBILITY[iconVisibility]);

        setLabelText(labelString);
        setValueText(valueString);
        if (iconDrawable != 0) {
            setIconImageRes(iconDrawable);
        }
    }

    private final void setText(TextView textView, @StringRes int resid) {
        if (textView != null) {
            textView.setText(resid);
        }
    }

    private final void setText(TextView textView, CharSequence text) {
        if (textView != null) {
            textView.setText(text);
        }
    }

    private final void setViewVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /**
     * 设置标题文本
     *
     * @param text
     */
    public final void setLabelText(CharSequence text) {
        setText(this.label, text);
    }

    /**
     * 设置标题文本
     *
     * @param resid
     */
    public final void setLabelText(@StringRes int resid) {
        setText(this.label, resid);
    }

    /**
     * 设置数值文本
     *
     * @param text
     */
    public final void setValueText(CharSequence text) {
        setText(this.value, text);
    }

    /**
     * 设置数值文本
     *
     * @param resid
     */
    public final void setValueText(@StringRes int resid) {
        setText(this.value, resid);
    }

    /**
     * 设置图标
     *
     * @param resid
     */
    public void setIconImageRes(@DrawableRes int resid) {
        if (icon != null) {
            icon.setImageResource(resid);
        }
    }

    /**
     * 设置图标
     *
     * @param drawable
     */
    public void setIconDrawable(Drawable drawable) {
        if (icon != null) {
            icon.setImageDrawable(drawable);
        }
    }
}
