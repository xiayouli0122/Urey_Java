package com.urey.story;
import java.io.File;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import net.sourceforge.pinyin4j.PinyinHelper;


public class CompartorList implements Comparator<File>{

	@Override
	public int compare(File o1, File o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();
		for (int i = 0; i < name1.length() && i < name2.length(); i++) {
            int codePoint1 = name1.charAt(i);
            int codePoint2 = name2.charAt(i);
            if (Character.isSupplementaryCodePoint(codePoint1)
                    || Character.isSupplementaryCodePoint(codePoint2)) {
                i++;
            }
            if (codePoint1 != codePoint2) {
                if (Character.isSupplementaryCodePoint(codePoint1)
                        || Character.isSupplementaryCodePoint(codePoint2)) {
                    return codePoint1 - codePoint2;
                }
                String pinyin1 = pinyin((char) codePoint1);
                String pinyin2 = pinyin((char) codePoint2);
                if (pinyin1 != null && pinyin2 != null) { // 两个字符都是汉字
                    if (!pinyin1.equals(pinyin2)) {
                        return pinyin1.compareTo(pinyin2);
                    }
                } else {
                    return codePoint1 - codePoint2;
                }
            }
        }
        return name1.length() - name2.length();
    }
    /**
     * 字符的拼音，多音字就得到第一个拼音。不是汉字，就return null。
     */
    private String pinyin(char c) {
        String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c);
        if (pinyins == null) {
            return null;
        }
        return pinyins[0];
    }


}
