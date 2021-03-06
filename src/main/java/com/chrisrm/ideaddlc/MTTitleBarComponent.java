/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 */

package com.chrisrm.ideaddlc;

import com.chrisrm.ideaddlc.listeners.ConfigNotifier;
import com.chrisrm.ideaddlc.listeners.CustomConfigNotifier;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.util.messages.MessageBusConnection;

/**
 * Component managing the title bar
 */
public final class MTTitleBarComponent implements ProjectComponent {
  private final MessageBusConnection connect;

  /**
   * Instantiates a new Mt title bar component.
   */
  @SuppressWarnings("AnonymousInnerClassMayBeStatic")
  public MTTitleBarComponent() {
    // Listen for changes on the settings
    connect = ApplicationManager.getApplication().getMessageBus().connect();
    connect.subscribe(ConfigNotifier.CONFIG_TOPIC, new ConfigNotifier() {
      @Override
      public void configChanged(final MTConfig mtConfig) {
        setDarkTitleBar();
      }
    });

    connect.subscribe(CustomConfigNotifier.CONFIG_TOPIC, mtCustomThemeConfig -> setDarkTitleBar());
  }

  @Override
  public void initComponent() {
    setDarkTitleBar();
  }

  /**
   * Activate dark title bar
   */
  @SuppressWarnings("WeakerAccess")
  static void setDarkTitleBar() {
    MTThemeManager.themeTitleBar();
  }

  @Override
  public void disposeComponent() {
    connect.disconnect();
  }
}
