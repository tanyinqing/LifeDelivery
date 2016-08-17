package com.linyou.lifedelivery.activity.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircularImage extends MaskedImage {
	public CircularImage(Context paramContext) {
		super(paramContext);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	public Bitmap createMask() {
		int i = getWidth();
		int j = getHeight();
		Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
		Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
		Canvas localCanvas = new Canvas(localBitmap);//����������ʵ��
		Paint localPaint = new Paint(1);//����һ�����ʵ�ʵ��
		//localPaint.setColor(-16777216);
		localPaint.setColor(-11222326);//���ʵ���ɫ
		float f1 = getWidth();
		float f2 = getHeight();
		RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);//Բ�����ĺͰ뾶
		localCanvas.drawOval(localRectF, localPaint);  //�ڻ����ϻ�Բ
		return localBitmap;
	}
}