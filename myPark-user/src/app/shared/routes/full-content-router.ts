import { Routes } from '@angular/router';

export const full_content : Routes = [

    { 
        path:'',
        loadChildren: () =>
            import('src/app/modules/home/home.module').then((m) => m.HomeModule),
    },
    // { 
    //     path:'user',
    //     loadChildren: () =>
    //         import('src/app/modules/user-home/user-home.module').then((m) => m.UserHomeModule)
    // },
    // { 
    //     path:'apropos',
    //     loadChildren: () =>
    //         import('src/app/modules/apropos/apropos.module').then((m) => m.AproposModule),
    // },
    // { 
    //     path:'contact',
    //     loadChildren: () =>
    //         import('src/app/modules/contact/contact.module').then((m) => m.ContactModule),
    // },
    // { 
    //     path:'connexion',
    //     loadChildren: () =>
    //         import('src/app/modules/connexion/connexion.module').then((m) => m.ConnexionModule),
    // },

];
