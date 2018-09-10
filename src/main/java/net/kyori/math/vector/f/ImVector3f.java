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
package net.kyori.math.vector.f;

import net.kyori.math.Mth;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class ImVector3f implements Vector3f {
  private static final ImVector3f ZERO = new ImVector3f(0f, 0f, 0f);
  private final float x;
  private final float y;
  private final float z;

  public static @NonNull ImVector3f zero() {
    return ZERO;
  }

  public static @NonNull ImVector3f of(final float n) {
    if(n == 0f) return ZERO;
    return new ImVector3f(n, n, n);
  }

  public static @NonNull ImVector3f of(final float x, final float y, final float z) {
    if(x == 0f && y == 0f && z == 0f) return ZERO;
    return new ImVector3f(x, y, z);
  }

  protected ImVector3f(final float x, final float y, final float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public float x() {
    return this.x;
  }

  @Override
  public @NonNull Vector3f x(final float x) {
    return of(x, this.y, this.z);
  }

  @Override
  public float y() {
    return this.y;
  }

  @Override
  public @NonNull Vector3f y(final float y) {
    return of(this.x, y, this.z);
  }

  @Override
  public float z() {
    return this.z;
  }

  @Override
  public @NonNull Vector3f z(final float z) {
    return of(this.x, this.y, z);
  }

  @Override
  public @NonNull Vector3f add(final float x, final float y, final float z) {
    return of(this.x + x, this.y + y, this.z + z);
  }

  @Override
  public @NonNull Vector3f sub(final float x, final float y, final float z) {
    return of(this.x - x, this.y - y, this.z - z);
  }

  @Override
  public @NonNull Vector3f mul(final float x, final float y, final float z) {
    return of(this.x * x, this.y * y, this.z * z);
  }

  @Override
  public @NonNull Vector3f div(final float x, final float y, final float z) {
    return of(this.x / x, this.y / y, this.z / z);
  }

  @Override
  public @NonNull Vector3f abs() {
    return of(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
  }

  @Override
  public @NonNull Vector3f ceil() {
    return of(Mth.ceil(this.x), Mth.ceil(this.y), Mth.ceil(this.z));
  }

  @Override
  public @NonNull Vector3f floor() {
    return of(Mth.floor(this.x), Mth.floor(this.y), Mth.floor(this.z));
  }

  @Override
  public @NonNull Vector3f negate() {
    return of(-this.x, -this.y, -this.z);
  }

  @Override
  public @NonNull Vector3f normalize() {
    final float length = this.length();
    return of(this.x / length, this.y / length, this.z / length);
  }

  @Override
  public @NonNull Vector3f pow(final float power) {
    return of((float) Math.pow(this.x, power), (float) Math.pow(this.y, power), (float) Math.pow(this.z, power));
  }

  @Override
  public @NonNull Vector3f round() {
    return of(Math.round(this.x), Math.round(this.y), Math.round(this.z));
  }

  @Override
  public float[] array() {
    return new float[]{
      this.x,
      this.y,
      this.z
    };
  }

  @Override
  public @NonNull Vector3f map(final @NonNull DoubleUnaryOperator operator) {
    return of((float) operator.applyAsDouble(this.x), (float) operator.applyAsDouble(this.y), (float) operator.applyAsDouble(this.z));
  }

  @Override
  public @NonNull Vector3f map(final @NonNull Vector3f that, final @NonNull DoubleBinaryOperator operator) {
    return of((float) operator.applyAsDouble(this.x, that.x()), (float) operator.applyAsDouble(this.y, that.y()), (float) operator.applyAsDouble(this.z, that.z()));
  }

  @Override
  public @NonNull Vector3f map(final @NonNull DoubleUnaryOperator x, final @NonNull DoubleUnaryOperator y, final @NonNull DoubleUnaryOperator z) {
    return of((float) x.applyAsDouble(this.x), (float) y.applyAsDouble(this.y), (float) z.applyAsDouble(this.z));
  }

  @Override
  public @NonNull Vector3f copy() {
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y, this.z);
  }

  @Override
  public boolean equals(final Object other) {
    return this == other || (other instanceof Vector3f && this.equals((Vector3f) other));
  }

  @Override
  public @NonNull String toString() {
    return String.format("%s{x=%f, y=%f, z=%f}", this.getClass().getSimpleName(), this.x, this.y, this.z);
  }
}
