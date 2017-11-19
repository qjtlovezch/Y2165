package cn.bdqn.contrpller06Execept;

import org.omg.CORBA.UserException;

/**
 * Created by Happy on 2017-08-20.
 */
public class AgeException extends UserException {
    public AgeException() {
        super();
    }

    public AgeException(String reason) {
        super(reason);
    }
}
