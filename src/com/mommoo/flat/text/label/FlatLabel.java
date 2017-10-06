package com.mommoo.flat.text.label;

import com.mommoo.flat.button.FlatButton;
import com.mommoo.flat.component.FlatPanel;
import com.mommoo.flat.frame.FlatFrame;
import com.mommoo.flat.layout.linear.LinearLayout;
import com.mommoo.flat.layout.linear.Orientation;
import com.mommoo.flat.layout.linear.constraints.LinearConstraints;
import com.mommoo.flat.layout.linear.constraints.LinearSpace;
import com.mommoo.flat.text.textarea.FlatTextAlignment;
import com.mommoo.flat.text.textarea.FlatTextArea;
import com.mommoo.flat.text.textfield.FlatTextField;
import com.mommoo.util.FontManager;
import com.mommoo.util.ScreenManager;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 *  FlatLabel is very convenient component.
 *  If text length over the label width, line jump automatically
 */

public class FlatLabel extends FlatTextArea {
	private static final int TEXT_FONT_SIZE = ScreenManager.getInstance().dip2px(8);

	public FlatLabel(){
		init();
	}

	public FlatLabel(String text){
		init();
		setText(text);
	}

	public FlatLabel(StyledDocument doc) {
		super(doc);
		init();
	}

	public static void main(String[] args){
//		SwingUtilities.invokeLater(()-> {
//
//
//		});

		FlatFrame flatFrame = new FlatFrame();
		flatFrame.setWindowExit(true);
		flatFrame.setTitle("FlatLabel Test");
		flatFrame.setLocationOnScreenCenter();

//			FlatLabel flatLabel = new FlatLabel("A Beautiful Label!!\n This is automatically line jump if string width longer than label width. You just use it well!");
		FlatLabel flatLabel = new FlatLabel("Test");
		flatLabel.setVerticalCenteredTextAlignment();
		flatLabel.setFont(FontManager.getNanumGothicFont(Font.BOLD, 50));
		flatLabel.setOnClickListener(component -> System.out.println(((FlatLabel) component).getText()));
//		flatLabel.setLineSpacing(0.7f);

		flatFrame.setSize(500, 700);

		flatFrame.getContainer().setLayout(new LinearLayout(Orientation.HORIZONTAL));
		flatFrame.getContainer().add(flatLabel, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
		flatLabel.setOpaque(true);
		flatLabel.setBackground(Color.RED);
		flatFrame.show();
	}

	private void init(){
		setEnableDragging(false);
//		setFont(FontManager.getNanumGothicFont(Font.PLAIN, TEXT_FONT_SIZE));
	}

	@Override
	public boolean isEditable() {
		return false;
	}

	public boolean isEnableDragging(){
		return isFocusable();
	}

	public void setEnableDragging(boolean enableDragging){
		setFocusable(enableDragging);
	}
}
