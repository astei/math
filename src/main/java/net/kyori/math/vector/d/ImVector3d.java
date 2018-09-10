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
package net.kyori.math.vector.d;

import net.kyori.math.Mth;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class ImVector3d implements Vector3d {
  private static final ImVector3d ZERO = new ImVector3d(0d, 0d, 0d);
  private final double x;
  private final double y;
  private final double z;

  public static @NonNull ImVector3d zero() {
    return ZERO;
  }

  public static @NonNull ImVector3d of(final double n) {
    if(n == 0d) return ZERO;
    return new ImVector3d(n, n, n);
  }

  public static @NonNull ImVector3d of(final double x, final double y, final double z) {
    if(x == 0d && y == 0d && z == 0d) return ZERO;
    return new ImVector3d(x, y, z);
  }

  protected ImVector3d(final double x, final double y, final double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public double x() {
    return this.x;
  }

  @Override
  public @NonNull Vector3d x(final double x) {
    return of(x, this.y, this.z);
  }

  @Override
  public double y() {
    return this.y;
  }

  @Override
  public @NonNull Vector3d y(final double y) {
    return of(this.x, y, this.z);
  }

  @Override
  public double z() {
    return this.z;
  }

  @Override
  public @NonNull Vector3d z(final double z) {
    return of(this.x, this.y, z);
  }

  @Override
  public @NonNull Vector3d add(final double x, final double y, final double z) {
    return of(this.x + x, this.y + y, this.z + z);
  }

  @Override
  public @NonNull Vector3d sub(final double x, final double y, final double z) {
    return of(this.x - x, this.y - y, this.z - z);
  }

  @Override
  public @NonNull Vector3d mul(final double x, final double y, final double z) {
    return of(this.x * x, this.y * y, this.z * z);
  }

  @Override
  public @NonNull Vector3d div(final double x, final double y, final double z) {
    return of(this.x / x, this.y / y, this.z / z);
  }

  @Override
  public @NonNull Vector3d abs() {
    return of(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
  }

  @Override
  public @NonNull Vector3d ceil() {
    return of(Mth.ceil(this.x), Mth.ceil(this.y), Mth.ceil(this.z));
  }

  @Override
  public @NonNull Vector3d floor() {
    return of(Mth.floor(this.x), Mth.floor(this.y), Mth.floor(this.z));
  }

  @Override
  public @NonNull Vector3d negate() {
    return of(-this.x, -this.y, -this.z);
  }

  @Override
  public @NonNull Vector3d normalize() {
    final double length = this.length();
    return of(this.x / length, this.y / length, this.z / length);
  }

  @Override
  public @NonNull Vector3d pow(final double power) {
    return of(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
  }

  @Override
  public @NonNull Vector3d round() {
    return of(Math.round(this.x), Math.round(this.y), Math.round(this.z));
  }

  @Override
  public double[] array() {
    return new double[]{
      this.x,
      this.y,
      this.z
    };
  }

  @Override
  public @NonNull Vector3d map(final @NonNull DoubleUnaryOperator operator) {
    return of(operator.applyAsDouble(this.x), operator.applyAsDouble(this.y), operator.applyAsDouble(this.z));
  }

  @Override
  public @NonNull Vector3d map(final @NonNull Vector3d that, final @NonNull DoubleBinaryOperator operator) {
    return of(operator.applyAsDouble(this.x, that.x()), operator.applyAsDouble(this.y, that.y()), operator.applyAsDouble(this.z, that.z()));
  }

  @Override
  public @NonNull Vector3d map(final @NonNull DoubleUnaryOperator x, final @NonNull DoubleUnaryOperator y, final @NonNull DoubleUnaryOperator z) {
    return of(x.applyAsDouble(this.x), y.applyAsDouble(this.y), z.applyAsDouble(this.z));
  }

  @Override
  public @NonNull Vector3d copy() {
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y, this.z);
  }

  @Override
  public boolean equals(final Object other) {
    return this == other || (other instanceof Vector3d && this.equals((Vector3d) other));
  }

  @Override
  public @NonNull String toString() {
    return String.format("%s{x=%f, y=%f, z=%f}", this.getClass().getSimpleName(), this.x, this.y, this.z);
  }
}
