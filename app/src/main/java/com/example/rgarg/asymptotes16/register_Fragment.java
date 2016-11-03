package com.example.rgarg.asymptotes16;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v7.app.AlertDialog;

/**
 * Created by RGARG on 1/28/2016.
 */
public class register_Fragment extends Fragment {
    @Nullable
    View rootView;
    WebView mWebView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.registeration_layout,container,false);
        mWebView = (WebView) rootView.findViewById(R.id.webview);

        String url = "http://goo.gl/forms/RhmDT2fS18";

        if(mWebView != null){
            mWebView.loadUrl(url);
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setTitle("  WARNING!!  ");
                    alertDialog.setMessage(" Check your internet connection! ");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            mWebView.loadUrl("javascript:window.location.reload( true )" );
                        }
                    });
                    alertDialog.setIcon(R.drawable.ic_warning_black_24dp);
                    alertDialog.show();
                }
            });
        }
        return rootView;
    }
}
