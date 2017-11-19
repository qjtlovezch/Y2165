package cn.bdqn.contrpller06Execept;

import org.omg.CORBA.UserException;

/**
 * Created by Happy on 2017-08-20.
 */
public class NameException extends UserException{
    public NameException() {
        super();
    }

    public NameException(String reason) {
        super(reason);
    }
}
