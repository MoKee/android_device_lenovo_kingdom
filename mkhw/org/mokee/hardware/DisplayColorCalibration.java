/*
 * Copyright (C) 2014 The CyanogenMod Project
 * Copyright (C) 2014 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mokee.hardware;

import org.mokee.internal.util.FileUtils;

public class DisplayColorCalibration {
    private static final String CONTROL_PATH = "/sys/class/graphics/fb0/rgb";

    public static boolean isSupported() {
        return FileUtils.isFileWritable(CONTROL_PATH);
    }

    public static int getMaxValue()  {
        return 32768;
    }

    public static int getMinValue()  {
        return 255;
    }

    public static int getDefValue() {
        return getMaxValue();
    }

    public static String getCurColors()  {
        return FileUtils.readOneLine(CONTROL_PATH);
    }

    public static boolean setColors(String colors) {
        return FileUtils.writeLine(CONTROL_PATH, colors);
    }
}
