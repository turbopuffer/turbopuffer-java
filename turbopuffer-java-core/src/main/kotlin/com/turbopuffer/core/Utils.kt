@file:JvmName("Utils")

package com.turbopuffer.core

import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.SortedMap

@JvmSynthetic
internal fun <T : Any> T?.getOrThrow(name: String): T =
    this ?: throw TurbopufferInvalidDataException("`${name}` is not present")

@JvmSynthetic
internal fun <T> List<T>.toImmutable(): List<T> =
    if (isEmpty()) Collections.emptyList() else Collections.unmodifiableList(toList())

@JvmSynthetic
internal fun <K, V> Map<K, V>.toImmutable(): Map<K, V> =
    if (isEmpty()) immutableEmptyMap() else Collections.unmodifiableMap(toMap())

@JvmSynthetic internal fun <K, V> immutableEmptyMap(): Map<K, V> = Collections.emptyMap()

@JvmSynthetic
internal fun <K : Comparable<K>, V> SortedMap<K, V>.toImmutable(): SortedMap<K, V> =
    if (isEmpty()) Collections.emptySortedMap()
    else Collections.unmodifiableSortedMap(toSortedMap(comparator()))

internal interface Enum
