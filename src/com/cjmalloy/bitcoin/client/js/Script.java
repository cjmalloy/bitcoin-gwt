package com.cjmalloy.bitcoin.client.js;

import com.google.gwt.core.client.JavaScriptObject;


public final class Script extends JavaScriptObject
{
    protected Script() {}

    public native String hash() /*-{

        return this.hash();
    }-*/;

    public native String toASM() /*-{

        return this.toASM();
    }-*/;

    public native String toHex() /*-{

        return this.toHex();
    }-*/;
}
