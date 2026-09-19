import { inject, Injectable, signal } from '@angular/core';
import { StorageService } from './shared/domain/storage.service';
import { AppStorageKey } from './app-storage-key.model';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  storageService = inject(StorageService);
  isDark = signal(this.storageService.get<boolean>(AppStorageKey.isDark) ?? false);

  toggle() {
    this.isDark.update(v => !v);
    this.storageService.save(AppStorageKey.isDark, this.isDark());
  }
}
