import { Injectable } from '@angular/core';
import { filter, map, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  private storageChanges = new Subject<{
    key: string;
    value: any;
  }>();

  save(key: string, value: any): void {
    localStorage.setItem(key, JSON.stringify(value));
    this.storageChanges.next({ key, value });
  }

  get<T>(key: string): T | null {
    const data = localStorage.getItem(key);
    return data ? JSON.parse(data) : null;
  }

  remove(key: string): void {
    localStorage.removeItem(key);
    this.storageChanges.next({ key, value: null });
  }

  clear(): void {
    localStorage.clear();
  }

  listen<T>(key: string): Observable<T> {
    return this.storageChanges.asObservable().pipe(
      filter(event => event.key === key && event.value !== null),
      map(event => event.value)
    );
  }
}
