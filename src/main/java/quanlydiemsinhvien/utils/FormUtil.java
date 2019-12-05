package quanlydiemsinhvien.utils;



import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
/**
 * Chuyển đổi các tham số trong url thành dạng key-value chứa trong một object
 * video số 8 phần phân trang và sort
 * @author hai.nv173089
 *
 */

public class FormUtil {
	@SuppressWarnings(value = "unchecked")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		try {
			object = (T) tClass.newInstance();
			// chuyển đổi các tham số trong request thành object
			// ví dụ: ?page=1& sort=title, desc thành một object
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return object;

	}
}
