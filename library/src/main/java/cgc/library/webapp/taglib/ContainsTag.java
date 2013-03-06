package cgc.library.webapp.taglib;

import java.util.Collection;

public class ContainsTag{
	 public static boolean contains(Collection<?> list, Object o) {
	      return list.contains(o);
	   }
}
