/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.chrisrm.ideaddlc.icons;

import com.chrisrm.ideaddlc.MTThemeManager;
import com.chrisrm.ideaddlc.icons.patchers.*;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.util.IconLoader;
import io.acari.DDLC.icons.patchers.AccentTintedIconsPatcher;
import org.jetbrains.annotations.NotNull;
@SuppressWarnings("OverlyCoupledClass")
public final class MTIconReplacerComponent implements BaseComponent {

  static {
    //todo: figure out how to have it be replaceable
    IconLoader.installPathPatcher(new AccentTintedIconsPatcher());
    IconLoader.installPathPatcher(new ThemedTintedIconsPatcher());
  }

  @SuppressWarnings("OverlyCoupledMethod")
  @Override
  public void initComponent() {
      useDDLCIcons();
  }

  public static void useDDLCIcons() {
    if(MTThemeManager.isDDLCActive()) {
      IconLoader.installPathPatcher(new LogPatcher());
      IconLoader.installPathPatcher(new AllIconsPatcher());
      IconLoader.installPathPatcher(new ImagesIconsPatcher());
      IconLoader.installPathPatcher(new VCSIconsPatcher());
      IconLoader.installPathPatcher(new GradleIconsPatcher());
      IconLoader.installPathPatcher(new TasksIconsPatcher());
      IconLoader.installPathPatcher(new MavenIconsPatcher());
      IconLoader.installPathPatcher(new TerminalIconsPatcher());
      IconLoader.installPathPatcher(new BuildToolsIconsPatcher());
      IconLoader.installPathPatcher(new RemoteServersIconsPatcher());
      IconLoader.installPathPatcher(new DatabaseToolsIconsPatcher());

      IconLoader.installPathPatcher(new PHPIconsPatcher());
      IconLoader.installPathPatcher(new PythonIconsPatcher());
      IconLoader.installPathPatcher(new CythonIconsPatcher());
      IconLoader.installPathPatcher(new MakoIconsPatcher());
      IconLoader.installPathPatcher(new JinjaIconsPatcher());
      IconLoader.installPathPatcher(new FlaskIconsPatcher());
      IconLoader.installPathPatcher(new DjangoIconsPatcher());
      IconLoader.installPathPatcher(new ChameleonIconsPatcher());

      IconLoader.installPathPatcher(new RubyIconsPatcher());

      IconLoader.installPathPatcher(new GolandIconsPatcher());
      IconLoader.installPathPatcher(new DataGripIconsPatcher());
      IconLoader.installPathPatcher(new CLionIconsPatcher());
      IconLoader.installPathPatcher(new AppCodeIconsPatcher());
      IconLoader.installPathPatcher(new RestClientIconsPatcher());

      IconLoader.installPathPatcher(new RiderIconsPatcher());
      IconLoader.installPathPatcher(new ResharperIconsPatcher());
    }

  }

  @Override
  public void disposeComponent() {

    MTIconPatcher.clearCache();
  }

  @Override
  @NotNull
  public String getComponentName() {
    return "com.chrisrm.ideaddlc.icons.MTIconReplacerComponent";
  }
}
