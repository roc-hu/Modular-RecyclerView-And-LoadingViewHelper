package com.lesehome.carrot.recycler.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hcp on 16/1/15.
 */
public class LinearDividerItemDecoration extends FlexibleDividerDecoration {

    private MarginProvider mMarginProvider;

    private boolean isVertical = true;//垂直排列的LinearLayout

    protected LinearDividerItemDecoration(Builder builder) {
        super(builder);
        mMarginProvider = builder.mMarginProvider;
    }

    @Override
    protected Rect getDividerBound(int position, RecyclerView parent, View child) {
        Rect bounds = new Rect(0, 0, 0, 0);
        int transitionX = (int) ViewCompat.getTranslationX(child);
        int transitionY = (int) ViewCompat.getTranslationY(child);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        if (isVertical) {
            bounds.left = parent.getPaddingLeft() +
                    mMarginProvider.dividerLeftMargin(position, parent) + transitionX;
            bounds.right = parent.getWidth() - parent.getPaddingRight() -
                    mMarginProvider.dividerRightMargin(position, parent) + transitionX;
        } else {
            bounds.top = parent.getPaddingTop() +
                    mMarginProvider.dividerTopMargin(position, parent) + transitionY;
            bounds.bottom = parent.getHeight() - parent.getPaddingBottom() -
                    mMarginProvider.dividerBottomMargin(position, parent) + transitionY;
        }


        int dividerSize = getDividerSize(position, parent);
        if (mDividerType == DividerType.DRAWABLE) {
            if (isVertical) {
                bounds.top = child.getBottom() + params.topMargin + transitionY;
                bounds.bottom = bounds.top + dividerSize;
            } else {
                bounds.left = child.getRight() + params.leftMargin + transitionX;
                bounds.right = bounds.left + dividerSize;
            }
        } else {
            if (isVertical) {
                bounds.top = child.getBottom() + params.topMargin + dividerSize / 2 + transitionY;
                bounds.bottom = bounds.top;
            } else {
                bounds.left = child.getRight() + params.leftMargin + dividerSize / 2 + transitionX;
                bounds.right = bounds.left;
            }
        }

        return bounds;
    }

    @Override
    protected void setItemOffsets(Rect outRect, int position, RecyclerView parent) {
        //取得列表是否是LinearLayoutManager 并且是否是垂直还是水平排列
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            isVertical = layoutManager.canScrollVertically();
        }else{
            throw new RuntimeException("The parent layout must be ‘LinearLayoutManager’!");
        }
        if (isVertical) {
            outRect.set(0, 0, 0, getDividerSize(position, parent));
        } else {
            outRect.set(0, 0, getDividerSize(position, parent), 0);
        }
    }

    private int getDividerSize(int position, RecyclerView parent) {
        if (mPaintProvider != null) {
            return (int) mPaintProvider.dividerPaint(position, parent).getStrokeWidth();
        } else if (mSizeProvider != null) {
            return mSizeProvider.dividerSize(position, parent);
        } else if (mDrawableProvider != null) {
            Drawable drawable = mDrawableProvider.drawableProvider(position, parent);
            return drawable.getIntrinsicHeight();
        }
        throw new RuntimeException("failed to get size");
    }

    /**
     * Interface for controlling divider margin
     */
    public interface MarginProvider {

        /**
         * Returns top margin of divider.
         *
         * @param position Divider position
         * @param parent   RecyclerView
         * @return top margin
         */
        int dividerTopMargin(int position, RecyclerView parent);

        /**
         * Returns bottom margin of divider.
         *
         * @param position Divider position
         * @param parent   RecyclerView
         * @return bottom margin
         */
        int dividerBottomMargin(int position, RecyclerView parent);

        /**
         * Returns left margin of divider.
         *
         * @param position Divider position
         * @param parent   RecyclerView
         * @return left margin
         */
        int dividerLeftMargin(int position, RecyclerView parent);

        /**
         * Returns right margin of divider.
         *
         * @param position Divider position
         * @param parent   RecyclerView
         * @return right margin
         */
        int dividerRightMargin(int position, RecyclerView parent);
    }

    public static class Builder extends FlexibleDividerDecoration.Builder<Builder> {

        private MarginProvider mMarginProvider = new MarginProvider() {
            @Override
            public int dividerTopMargin(int position, RecyclerView parent) {
                return 0;
            }

            @Override
            public int dividerBottomMargin(int position, RecyclerView parent) {
                return 0;
            }

            @Override
            public int dividerLeftMargin(int position, RecyclerView parent) {
                return 0;
            }

            @Override
            public int dividerRightMargin(int position, RecyclerView parent) {
                return 0;
            }
        };

        public Builder(Context context) {
            super(context);
        }

        public Builder margin(final int topMargin, final int bottomMargin, final int leftMargin, final int rightMargin) {
            return marginProvider(new MarginProvider() {
                @Override
                public int dividerTopMargin(int position, RecyclerView parent) {
                    return topMargin;
                }

                @Override
                public int dividerBottomMargin(int position, RecyclerView parent) {
                    return bottomMargin;
                }

                @Override
                public int dividerLeftMargin(int position, RecyclerView parent) {
                    return leftMargin;
                }

                @Override
                public int dividerRightMargin(int position, RecyclerView parent) {
                    return rightMargin;
                }
            });
        }

        public Builder margin(int margin) {
            return margin(margin, margin, margin, margin);
        }

        public Builder marginResId(@DimenRes int topMarginIdOrLeftMarginId, @DimenRes int bottomMarginIdOrRightMarginId) {
            return margin(
                    mResources.getDimensionPixelSize(topMarginIdOrLeftMarginId),
                    mResources.getDimensionPixelSize(bottomMarginIdOrRightMarginId),
                    mResources.getDimensionPixelSize(topMarginIdOrLeftMarginId),
                    mResources.getDimensionPixelSize(bottomMarginIdOrRightMarginId));
        }

        public Builder marginResId(@DimenRes int marginId) {
            return marginResId(marginId, marginId);
        }

        public Builder marginProvider(MarginProvider provider) {
            mMarginProvider = provider;
            return this;
        }

        public LinearDividerItemDecoration build() {
            checkBuilderParams();
            return new LinearDividerItemDecoration(this);
        }
    }
}