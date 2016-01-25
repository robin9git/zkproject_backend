package org.jeecgframework.core.util;

import java.util.Comparator;

import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.zky.pojo.base.ZkZhMenu;
import org.jeecgframework.web.zkyen.pojo.base.MenuEN;

/**
* @ClassName: NumberComparator 
* @Description: TODO(字符串比较器) 
* @author jeecg 
* @date 2013-1-31 下午06:18:35 
*
 */
public class NumberComparator implements Comparator<Object> {
	private boolean ignoreCase = true;

	public NumberComparator() {
	}

	public NumberComparator(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	public int compare(Object obj1, Object obj2) {
		String o1 = "";
		String o2 = "";
		if (ignoreCase) {
			if(TSFunction.class.isInstance(obj1)){
				TSFunction c1 = (TSFunction) obj1;
				TSFunction c2 = (TSFunction) obj2;
				o1 = c1.getFunctionOrder();
				o2 = c2.getFunctionOrder();
			}else if(MenuEN.class.isInstance(obj1)){
				MenuEN c1 = (MenuEN) obj1;
				MenuEN c2 = (MenuEN) obj2;
				o1 = c1.getFunctionOrder();
				o2 = c2.getFunctionOrder();
			}else{
				ZkZhMenu c1 = (ZkZhMenu) obj1;
				ZkZhMenu c2 = (ZkZhMenu) obj2;
				o1 = c1.getFunctionOrder();
				o2 = c2.getFunctionOrder();
			}
		}
		if (o1 != null && o2 != null) {
			for (int i = 0; i < o1.length(); i++) {
				if (i == o1.length() && i < o2.length()) {
					return -1;
				} else if (i == o2.length() && i < o1.length()) {
					return 1;
				}
				char ch1 = o1.charAt(i);
				char ch2 = o2.charAt(i);
				if (ch1 >= '0' && ch2 <= '9') {
					int i1 = getNumber(o1.substring(i));
					int i2 = getNumber(o2.substring(i));
					if (i1 == i2) {
						continue;
					} else {
						return i1 - i2;
					}
				} else if (ch1 != ch2) {
					return ch1 - ch2;
				}
			}
		}
		return 0;
	}

	private int getNumber(String str) {
		int num = Integer.MAX_VALUE;
		int bits = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				bits++;
			} else {
				break;
			}
		}
		if (bits > 0) {
			num = Integer.parseInt(str.substring(0, bits));
		}
		return num;
	}
}
