package com.bronze.me.domain.interactor;

import com.bronze.me.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetUserDetailsUseCase extends UseCase {

    private final int userId;
    private final UserRepository userRepository;

    @Inject
    public GetUserDetailsUseCase(int userId, UserRepository userRepository) {
        this.userId = userId;
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.getUser(this.userId);
    }
}
