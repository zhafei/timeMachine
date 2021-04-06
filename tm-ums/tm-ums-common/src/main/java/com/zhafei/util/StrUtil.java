package com.zhafei.util;

/**
 * 字符串工具类
 */
public class StrUtil {
	/**
	 * 字符串是否为空白 空白的定义如下： <br>
	 * 1、为null <br>
	 * 2、为不可见字符（如空格）<br>
	 * 3、""<br>
	 *
	 * @param str 被检测的字符串
	 * @return 是否为空
	 */
	public static boolean isBlank(CharSequence str) {
		int length;

		if ((str == null) || ((length = str.length()) == 0)) {
			return true;
		}

		for (int i = 0; i < length; i++) {
			// 只要有一个非空字符即为非空字符串
			if (Character.isWhitespace(str.charAt(i))
					|| Character.isSpaceChar(str.charAt(i))
					|| str.charAt(i) == '\ufeff'
					|| str.charAt(i) == '\u202a') {
				return false;
			}
		}

		return true;
	}
}