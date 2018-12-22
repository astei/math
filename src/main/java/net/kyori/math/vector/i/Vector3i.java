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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public interface Vector3i extends Vectori {
  int x();

  @NonNull Vector3i x(final int x);

  int y();

  @NonNull Vector3i y(final int y);

  int z();

  @NonNull Vector3i z(final int z);

  @Override
  default boolean isZero() {
    return this.x() == 0 && this.y() == 0 && this.z() == 0;
  }

  @NonNull Vector3i add(final int x, final int y, final int z);

  default @NonNull Vector3i add(final Vector3i that) {
    return this.add(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3i add(final int n) {
    return this.add(n, n, n);
  }

  @NonNull Vector3i sub(final int x, final int y, final int z);

  default @NonNull Vector3i sub(final Vector3i that) {
    return this.sub(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3i sub(final int n) {
    return this.sub(n, n, n);
  }

  @NonNull Vector3i mul(final int x, final int y, final int z);

  default @NonNull Vector3i mul(final Vector3i that) {
    return this.mul(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3i mul(final int n) {
    return this.mul(n, n, n);
  }

  @NonNull Vector3i div(final int x, final int y, final int z);

  default @NonNull Vector3i div(final Vector3i that) {
    return this.div(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3i div(final int n) {
    return this.div(n, n, n);
  }

  @Override
  @NonNull Vector3i abs();

  @Override
  @NonNull Vector3i negate();

  @Override
  @NonNull Vector3i pow(final int power);

  @Override
  default int lengthSquared() {
    final int x = this.x();
    final int y = this.y();
    final int z = this.z();
    return x * x + y * y + z * z;
  }

  default @NonNull Vector3i minimum(final @NonNull Vector3i that) {
    return this.map(that, Math::min);
  }

  default @NonNull Vector3i maximum(final @NonNull Vector3i that) {
    return this.map(that, Math::max);
  }

  @Override
  default @NonNull IntStream stream() {
    return IntStream.of(this.x(), this.y(), this.z());
  }

  @Override
  @NonNull Vector3i map(final @NonNull IntUnaryOperator operator);

  @NonNull Vector3i map(final @NonNull Vector3i that, final @NonNull IntBinaryOperator operator);

  @NonNull Vector3i map(final @NonNull IntUnaryOperator x, final @NonNull IntUnaryOperator y, final @NonNull IntUnaryOperator z);

  @Override
  default boolean allMatch(final @NonNull IntPredicate predicate) {
    return predicate.test(this.x()) && predicate.test(this.y()) && predicate.test(this.z());
  }

  @Override
  default boolean anyMatch(final @NonNull IntPredicate predicate) {
    return predicate.test(this.x()) || predicate.test(this.y()) || predicate.test(this.z());
  }

  @Override @NonNull Vector3i copy();

  default boolean equals(final @Nullable Vector3i that) {
    return that != null
      && this.x() == that.x()
      && this.y() == that.y()
      && this.z() == that.z();
  }

  default int dot(Vector3i other) {
    return this.x() * other.x() + this.y() * other.y() + this.z() * other.z();
  }
}
