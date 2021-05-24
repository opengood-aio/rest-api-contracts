package io.opengood.api.rest.contracts.record

data class RecordData(
    val total: Long
) {
    companion object {
        val EMPTY = RecordData(
            total = 0
        )
    }
}
