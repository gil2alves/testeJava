
# 🌐 Experiência com Angular

Tenho experiência prática com **Angular**, especialmente entre as versões **Angular 10** e **Angular 17**, desenvolvendo interfaces modernas, dinâmicas e escaláveis para aplicações web. Durante meu trabalho, utilizei Angular em diversos cenários, explorando seus recursos principais e melhores práticas.

---

## 🚀 Principais Recursos e Ferramentas Utilizadas

### 1. **Componentes**
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-exemplo',
  template: `<h1>{{ titulo }}</h1>`,
  styleUrls: ['./exemplo.component.css']
})
export class ExemploComponent {
  titulo: string = 'Bem-vindo ao Angular!';
}
```

---

### 2. **Serviços e Injeção de Dependência**
```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private apiUrl = 'https://api.exemplo.com/produtos';

  constructor(private http: HttpClient) {}

  buscarProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.apiUrl);
  }
}
```

---

### 3. **Data Binding (Two-Way Binding)**
```html
<input [(ngModel)]="nome" placeholder="Digite seu nome">
<p>Olá, {{ nome }}!</p>
```

---

### 4. **Diretivas (`*ngIf`, `*ngFor`)**
```html
<div *ngIf="produtos.length > 0">
  <ul>
    <li *ngFor="let produto of produtos">{{ produto.nome }}</li>
  </ul>
</div>
```

---

### 5. **Pipes**
```html
<p>Preço: {{ preco | currency:'BRL' }}</p>
```

---

### 6. **Roteamento (Routing)**
```typescript
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produtos', component: ProdutoComponent },
  { path: '**', redirectTo: 'home' }
];
```

---

### 7. **Formulários Reativos (Reactive Forms)**
```typescript
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html'
})
export class ContatoComponent {
  contatoForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.contatoForm = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      mensagem: ['', Validators.required]
    });
  }

  enviarFormulario() {
    if (this.contatoForm.valid) {
      console.log(this.contatoForm.value);
    }
  }
}
```

---

### 8. **Gerenciamento de Estado com RxJS**
```typescript
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {
  private produtos = new BehaviorSubject<Produto[]>([]);
  produtos$ = this.produtos.asObservable();

  adicionarProduto(produto: Produto) {
    const listaAtual = this.produtos.value;
    this.produtos.next([...listaAtual, produto]);
  }
}
```

---

### 9. **Interceptors**
```typescript
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token');
    const clone = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });
    return next.handle(clone);
  }
}
```

---

### 10. **Testes com Jasmine e Karma**
```typescript
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ExemploComponent } from './exemplo.component';

describe('ExemploComponent', () => {
  let component: ExemploComponent;
  let fixture: ComponentFixture<ExemploComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExemploComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(ExemploComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('deve criar o componente', () => {
    expect(component).toBeTruthy();
  });
});
```

---

## 📋 Casos de Uso na Prática
✅ Desenvolvimento de dashboards administrativos com gráficos interativos usando **ApexCharts**.  
✅ Implementação de telas complexas com formulários condicionais e painéis expansíveis.  
✅ Criação de uma aplicação financeira que manipula dados em tempo real via **WebSocket**.  
✅ Construção de um sistema de controle de estoque com filtros avançados e tabelas dinâmicas usando **`MatTable`**.  
✅ Implementação de rotinas de autenticação utilizando **Keycloak** para segurança.  

---

## 📈 Conclusão
Minha experiência com Angular envolve tanto o desenvolvimento de aplicações modulares e escaláveis quanto a adoção de boas práticas de segurança e otimização. Se quiser detalhes específicos de projetos, desafios técnicos ou padrões avançados que utilizei, estou à disposição! 🚀
