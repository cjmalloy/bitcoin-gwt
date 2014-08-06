package com.cjmalloy.bitcoin.client.js;

import com.google.gwt.core.client.JavaScriptObject;


public final class ECKey extends JavaScriptObject
{
    protected ECKey() {}

    public native ECSignature sign(String hash) /*-{

        return this.sign(hash);
    }-*/;

    //TODO: Add support for other networks
    public native String toWIF() /*-{

        return this.toWIF();
    }-*/;
}
