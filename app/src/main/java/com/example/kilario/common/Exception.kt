package com.example.kilario.common

import java.io.IOException

class NetworkException(message: String) : IOException(message)

class NotFoundException(message: String) : IOException(message)