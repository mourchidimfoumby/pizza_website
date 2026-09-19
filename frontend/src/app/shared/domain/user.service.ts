import { inject, Injectable } from '@angular/core';
import { StorageService } from './storage.service';
import { User } from './entity/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  storageService = inject(StorageService);

  getUser() {
    return this.storageService.get<User>('user');
  }
}
