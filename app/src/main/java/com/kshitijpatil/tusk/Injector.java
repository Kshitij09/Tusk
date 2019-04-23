package com.kshitijpatil.tusk;

import com.kshitijpatil.tusk.ui.data.Repository;

/**
 * Factory implementation for dependency injection
 */
public class Injector {
    public static Repository provideRepository() {
        return Repository.getInstance();
    }
}
