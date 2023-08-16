package com.korbyte.alphavantage.base;

import java.io.IOException;
import java.net.URISyntaxException;


public interface ApiInterface<R, T> {

  T get(R req) throws URISyntaxException, IOException;
}
