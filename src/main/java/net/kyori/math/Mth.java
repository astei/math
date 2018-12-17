/*
 * This file is part of math, licensed under the MIT License.
 *
 * Copyright (c) 2017-2018 KyoriPowered
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
 */
package net.kyori.math;

public final class Mth {
  public static double clamp(final double value, final double min, final double max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  public static float clamp(final float value, final float min, final float max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  public static int clamp(final int value, final int min, final int max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  public static long clamp(final long value, final long min, final long max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  public static int floor(final double dv) {
    final int iv = (int) dv;
    return dv < iv ? iv - 1 : iv;
  }

  public static int floor(final float fv) {
    final int iv = (int) fv;
    return fv < iv ? iv - 1 : iv;
  }

  public static int ceil(final double dv) {
    final int iv = (int) dv;
    return dv > iv ? iv + 1 : iv;
  }

  public static int ceil(final float fv) {
    final int iv = (int) fv;
    return fv > iv ? iv + 1 : iv;
  }

  public static float sqrt(final float value) {
    return (float) Math.sqrt(value);
  }
}
