package com.bronze.me.domain.interactor;


import com.bronze.me.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetUserListUseCase extends UseCase {

    private final UserRepository userRepository;

    @Inject
    public GetUserListUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return this.userRepository.getUsers();
    }
}
