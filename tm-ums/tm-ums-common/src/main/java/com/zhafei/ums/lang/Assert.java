package com.zhafei.ums.lang;

/**
 * 断言<br>
 * 断言某些对象或值是否符合规定，否则抛出异常。经常用于做变量检查
 * @author yyf
 */
public class Assert {

	/**
	 * 断言对象是否为{@code null} ，如果不为{@code null} 抛出{@link IllegalArgumentException} 异常
	 * 
	 * <pre class="code">
	 * Assert.isNull(value);
	 * </pre>
	 * 
	 * @param object 被检查对象
	 * @throws IllegalArgumentException if the object is not {@code null}
	 */
	public static void isNull(Object object) throws IllegalArgumentException {
		if (object != null) {
			throw new IllegalArgumentException("[Assertion failed] - the object argument must be null");
		}
	}

	/**
	 * 断言对象是否不为{@code null} ，如果为{@code null} 抛出{@link IllegalArgumentException} 异常
	 * 
	 * <pre class="code">
	 * Assert.notNull(clazz);
	 * </pre>
	 * 
	 * @param <T> 被检查对象类型
	 * @param object 被检查对象
	 * @return 非空对象
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static <T> T notNull(T object) throws IllegalArgumentException {
		if (object == null) {
			throw new IllegalArgumentException("[Assertion failed] - this argument is required; it must not be null");
		}
		return object;
	}

	/**
	 * 检查值是否在指定范围内
	 *
	 * @param value 值
	 * @param min 最小值（包含）
	 * @param max 最大值（包含）
	 * @return 检查后的长度值
	 * @since 4.1.10
	 */
	public static Number checkBetween(Number value, Number min, Number max) {
		notNull(value);
		notNull(min);
		notNull(max);
		double valueDouble = value.doubleValue();
		double minDouble = min.doubleValue();
		double maxDouble = max.doubleValue();
		if (valueDouble < minDouble || valueDouble > maxDouble) {
			throw new IllegalArgumentException("Length must be between "+min+" and "+max+".");
		}
		return value;
	}

}
