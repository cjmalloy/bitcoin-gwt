package com.cjmalloy.bitcoin.client.js;

import com.google.gwt.core.client.JavaScriptObject;


public final class ECPubKey extends JavaScriptObject
{
    protected ECPubKey() {}

    //TODO: Add support for other networks
    public native Address getAddress() /*-{

        return this.getAddress();
    }-*/;

    public native String toHex() /*-{

        return this.toHex();
    }-*/;

    public native boolean verify(String hash, ECSignature signature) /*-{

        return this.verify(hash, signature);
    }-*/;
}
