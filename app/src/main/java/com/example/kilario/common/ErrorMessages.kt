package com.example.kilario.common

import com.example.kilario.R

enum class ErrorMessages (val stringRes: Int) {
    NETWORK(R.string.error_message_network),
    NETWORK_TIMEOUT(R.string.error_message_timeout)
}