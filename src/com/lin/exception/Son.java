package com.lin.exception;

import java.sql.SQLException;

public class Son extends Father {
    @Override
    public void start() throws Exception{
        throw new SQLException();
    }
}
