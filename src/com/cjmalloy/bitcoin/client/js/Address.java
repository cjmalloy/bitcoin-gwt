package com.cjmalloy.bitcoin.client.js;

import com.google.gwt.core.client.JavaScriptObject;


public final class Address extends JavaScriptObject
{
    protected Address() {}

    public native String toBase58Check() /*-{

        return this.toBase58Check();
    }-*/;

    public native Script toOutputScript() /*-{

        return this.toOutputScript();
    }-*/;
}
