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
package net.kyori.math.vector.i;

import net.kyori.math.Mth;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ImVector3i implements Vector3i {
  private static final ImVector3i ZERO = new ImVector3i(0, 0, 0);
  private final int x;
  private final int y;
  private final int z;

  public static @NonNull ImVector3i zero() {
    return ZERO;
  }

  public static @NonNull ImVector3i of(final int n) {
    if(n == 0) return ZERO;
    return new ImVector3i(n, n, n);
  }

  public static @NonNull ImVector3i of(final int x, final int y, final int z) {
    if(x == 0 && y == 0 && z == 0) return ZERO;
    return new ImVector3i(x, y, z);
  }

  public static @NonNull ImVector3i of(final double x, final double y, final double z) {
    return x == 0 && y == 0 && z == 0 ? ZERO : new ImVector3i(Mth.floor(x), Mth.floor(y), Mth.floor(z));
  }

  public static @NonNull ImVector3i of(final float x, final float y, final float z) {
    return x == 0 && y == 0 && z == 0 ? ZERO : new ImVector3i(Mth.floor(x), Mth.floor(y), Mth.floor(z));
  }

  protected ImVector3i(final int x, final int y, final int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public int x() {
    return this.x;
  }

  @Override
  public @NonNull Vector3i x(final int x) {
    return of(x, this.y, this.z);
  }

  @Override
  public int y() {
    return this.y;
  }

  @Override
  public @NonNull Vector3i y(final int y) {
    return of(this.x, y, this.z);
  }

  @Override
  public int z() {
    return this.z;
  }

  @Override
  public @NonNull Vector3i z(final int z) {
    return of(this.x, this.y, z);
  }

  @Override
  public @NonNull Vector3i add(final int x, final int y, final int z) {
    return of(this.x + x, this.y + y, this.z + z);
  }

  @Override
  public @NonNull Vector3i sub(final int x, final int y, final int z) {
    return of(this.x - x, this.y - y, this.z - z);
  }

  @Override
  public @NonNull Vector3i mul(final int x, final int y, final int z) {
    return of(this.x * x, this.y * y, this.z * z);
  }

  @Override
  public @NonNull Vector3i div(final int x, final int y, final int z) {
    return of(this.x / x, this.y / y, this.z / z);
  }

  @Override
  public @NonNull Vector3i abs() {
    return of(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
  }

  @Override
  public @NonNull Vector3i negate() {
    return of(-this.x, -this.y, -this.z);
  }

  @Override
  public @NonNull Vector3i pow(final int power) {
    return of(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
  }

  @Override
  public int[] array() {
    return new int[]{
      this.x,
      this.y,
      this.z
    };
  }

  @Override
  public @NonNull Vector3i map(final @NonNull IntUnaryOperator operator) {
    return of(operator.applyAsInt(this.x), operator.applyAsInt(this.y), operator.applyAsInt(this.z));
  }

  @Override
  public @NonNull Vector3i map(final @NonNull Vector3i that, final @NonNull IntBinaryOperator operator) {
    return of(operator.applyAsInt(this.x, that.x()), operator.applyAsInt(this.y, that.y()), operator.applyAsInt(this.z, that.z()));
  }

  @Override
  public @NonNull Vector3i map(final @NonNull IntUnaryOperator x, final @NonNull IntUnaryOperator y, final @NonNull IntUnaryOperator z) {
    return of(x.applyAsInt(this.x), y.applyAsInt(this.y), z.applyAsInt(this.z));
  }

  @Override
  public @NonNull Vector3i copy() {
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y, this.z);
  }

  @Override
  public boolean equals(final Object other) {
    return this == other || (other instanceof Vector3i && this.equals((Vector3i) other));
  }

  @Override
  public @NonNull String toString() {
    return String.format("%s{x=%d, y=%d, z=%d}", this.getClass().getSimpleName(), this.x, this.y, this.z);
  }
}
