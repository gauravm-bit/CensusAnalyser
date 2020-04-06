package service;

import java.io.Reader;
import java.util.Iterator;

public interface ICSVBuilder {
     <E> Iterator getIterator(Reader reader, Class csvClass);
}
