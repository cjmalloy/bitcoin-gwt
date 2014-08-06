package com.cjmalloy.bitcoin.client.js;

import com.google.gwt.core.client.JavaScriptObject;


public final class HDNode extends JavaScriptObject
{
    protected HDNode() {}

    public native HDNode derive(int index) /*-{

        return this.derive(index);
    }-*/;

    public native HDNode deriveHardened(int index) /*-{

        return this.deriveHardened(index);
    }-*/;

    public native Address getAddress() /*-{

        return this.getAddress();
    }-*/;

    public native String getFingerprint() /*-{

        return this.getFingerprint();
    }-*/;

    public native String getIdentifier() /*-{

        return this.getIdentifier();
    }-*/;

    public native HDNode neutered() /*-{

        return this.neutered();
    }-*/;

    public native String toBase58() /*-{

        return this.toBase58();
    }-*/;

    public native String toHex() /*-{

        return this.toHex();
    }-*/;
}
